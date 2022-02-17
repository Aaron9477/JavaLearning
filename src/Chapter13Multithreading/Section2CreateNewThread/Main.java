package Chapter13Multithreading.Section2CreateNewThread;

public class Main {
    public static void main(String[] args) {
        // Java语言内置了多线程支持。当Java程序启动的时候，实际上是启动了一个JVM进程，然后，JVM启动主线程来执行main()方法。在main()方法中，我们又可以启动其他线程。
        // 要创建一个新线程非常容易，我们需要实例化一个Thread实例，然后调用它的start()方法：
        Thread t = new Thread();
        t.start(); // 启动新线程

        MyThread t2 = new MyThread();
        t2.start(); // 启动新线程

        Thread t3 = new Thread(new MyRunnable());
        t3.start(); // 启动新线程

        // 或者用Java8引入的lambda语法进一步简写为：
        Thread t4 = new Thread(() -> {
            System.out.println("start new thread!");
        });
        t4.start(); // 启动新线程

        // 使用线程执行的打印语句，和直接在main()方法执行有区别吗
        System.out.println("5main start...");
        Thread t5 = new Thread() {
            public void run() {
                System.out.println("5thread run...");
                System.out.println("5thread end.");
            }
        };
        t5.start();
        System.out.println("5main end...");

        // 我们用蓝色表示主线程，也就是main线程，main线程执行的代码有4行，首先打印main start，然后创建Thread对象，紧接着调用start()启动新线程。当start()方法被调用时，JVM就创建了一个新线程，我们通过实例变量t来表示这个新线程对象，并开始执行。
        //
        //接着，main线程继续执行打印main end语句，而t线程在main线程执行的同时会并发执行，打印thread run和thread end语句。
        //
        //当run()方法结束时，新线程就结束了。而main()方法结束时，主线程也结束了。
        //
        //我们再来看线程的执行顺序：
        //
        //main线程肯定是先打印main start，再打印main end；
        //t线程肯定是先打印thread run，再打印thread end。
        //但是，除了可以肯定，main start会先打印外，main end打印在thread run之前、thread end之后或者之间，都无法确定。因为从t线程开始运行以后，两个线程就开始同时运行了，并且由操作系统调度，程序本身无法确定线程的调度顺序。
    }
}

// 方法一：从Thread派生一个自定义类，然后覆写run()方法：
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}

// 方法二：创建Thread实例时，传入一个Runnable实例：
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread!");
    }
}