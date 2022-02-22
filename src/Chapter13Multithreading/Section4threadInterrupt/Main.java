package Chapter13Multithreading.Section4threadInterrupt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 中断一个线程非常简单，只需要在其他线程中对目标线程调用interrupt()方法
        // 目标线程需要反复检测自身状态是否是interrupted状态，如果是，就立刻结束运行。
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1); // 暂停1毫秒
        t.interrupt(); // 中断t线程
        t.join(); // 等待t线程结束
        System.out.println("end");

        Thread t2 = new MyThread2();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt(); // 中断t线程
        t2.join(); // 等待t线程结束
        System.out.println("end");

        // 另一个常用的中断线程的方法是设置标志位。我们通常会用一个running标志位来标识线程是否应该继续运行
        // 在外部线程中，通过把HelloThread.running置为false，就可以让线程结束：
        HelloThread2 t3 = new HelloThread2();
        t3.start();
        Thread.sleep(1);
        t3.running = false; // 标志位置为false
    }
}

class MyThread extends Thread {
    // main线程通过调用t.interrupt()方法中断t线程，但是要注意，interrupt()方法仅仅向t线程发出了“中断请求”
    // 至于t线程是否能立刻响应，要看具体代码。而t线程的while循环会【检测isInterrupted()】，所以上述代码能正确响应interrupt()请求，使得自身立刻结束运行run()方法。
    public void run() {
        int n = 0;
        while (! isInterrupted()) {
            n ++;
            System.out.println(n + " hello!");
        }
    }
}

class MyThread2 extends Thread {
    public void run() {
        Thread hello = new HelloThread();
        hello.start(); // 启动hello线程
        try {
            hello.join(); // 等待hello线程结束
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        }
        hello.interrupt();
    }
}

class HelloThread extends Thread {
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello!");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}

class HelloThread2 extends Thread {
    // 注意到HelloThread的标志位boolean running是一个线程间共享的变量。
    // 线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值
    public volatile boolean running = true;
    public void run() {
        int n = 0;
        while (running) {
            n ++;
            System.out.println(n + " hello!");
        }
        System.out.println("end!");
    }
}

// 为什么要对线程间共享的变量用关键字volatile声明？这涉及到Java的内存模型。
// 在Java虚拟机中，变量的值保存在主内存中，但是，当线程访问变量时，它会先获取一个副本，并保存在自己的工作内存中。
// 如果线程修改了变量的值，虚拟机会在某个时刻把修改后的值回写到主内存，但是，这个时间是不确定的！

// 这会导致如果一个线程更新了某个变量，另一个线程读取的值可能还是更新前的。
// 例如，主内存的变量a = true，线程1执行a = false时，它在此刻仅仅是把变量a的副本变成了false，主内存的变量a还是true
// 在JVM把修改后的a回写到主内存之前，其他线程读取到的a的值仍然是true，这就造成了多线程之间共享的变量不一致。

// 因此，volatile关键字的目的是告诉虚拟机：
// 每次访问变量时，总是获取主内存的最新值；
// 每次修改变量后，立刻回写到主内存。

// volatile关键字解决的是可见性问题：当一个线程修改了某个共享变量的值，其他线程能够立刻看到修改后的值。