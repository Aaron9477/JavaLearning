package Chapter13Multithreading.Section6ThreadSynchronization;

public class Main {
    public static void main(String[] args) throws Exception {
        // 下面的代码很简单，两个线程同时对一个int变量进行操作，一个加10000次，一个减10000次，最后结果应该是0，但是，每次运行，结果实际上都是不一样的。
        // 这是因为对变量进行读取和写入时，结果要正确，必须保证是原子操作。原子操作是指不能被中断的一个或一系列操作。
        // 【原子操作就是不可中断的一个或一系列的操作】
        AddThread add = new AddThread();
        DecThread dec = new DecThread();
        add.start();
        dec.start();
        add.join();
        dec.join();
        System.out.println(Counter.count);

        // 通过加锁和解锁的操作，就能保证3条指令总是在一个线程执行期间，不会有其他线程会进入此指令区间。
        // 即使在执行期线程被操作系统中断执行，其他线程也会因为无法获得锁导致无法进入此指令区间。
        // 只有执行线程将锁释放后，其他线程才有机会获得锁并执行。这种加锁和解锁之间的代码块我们称之为临界区（Critical Section），任何时候临界区最多只有一个线程能执行。

        // 可见，保证一段代码的原子性就是通过加锁和解锁实现的。Java程序使用synchronized关键字对一个对象进行加锁：
        // synchronized(lock) {
        //     n = n + 1;
        // }

        // 它表示用Counter.lock实例作为锁，两个线程在执行各自的synchronized(Counter.lock) { ... }代码块时，必须先获得锁，才能进入代码块进行。
        // 执行结束后，在synchronized语句块结束会自动释放锁。这样一来，对Counter.count变量进行读写就不可能同时进行。上述代码无论运行多少次，最终结果都是0。
        // 使用synchronized解决了多线程同步访问共享变量的正确性问题。但是，它的缺点是带来了性能下降。
        // 因为synchronized代码块无法并发执行。此外，加锁和解锁需要消耗一定的时间，所以，synchronized会降低程序的执行效率。
        AddThread2 add2 = new AddThread2();
        DecThread2 dec2 = new DecThread2();
        add2.start();
        dec2.start();
        add2.join();
        dec2.join();
        System.out.println(Counter2.count);

    }
}

class Counter {
    public static int count = 0;
}

class AddThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) { Counter.count += 1; }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) { Counter.count -= 1; }
    }
}

class Counter2 {
    // 互为原子操作的对象，需要对同一个对象上锁！！！！！
    public static final Object lock = new Object();
    public static int count = 0;
}

class AddThread2 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock) {
                Counter.count += 1;
            }
        }
    }
}

class DecThread2 extends Thread {
    public void run() {
        for (int i=0; i<10000; i++) {
            synchronized(Counter2.lock) {
                Counter.count -= 1;
            }
        }
    }
}
