package Chapter13Multithreading.Section8Deadlock;

public class Main {
    public static void main(String[] args) throws Exception {
    }
}

// Java的线程锁是可重入的锁。
// 观察synchronized修饰的add()方法，一旦线程执行到add()方法内部，说明它已经获取了当前实例的this锁。
// 如果传入的n < 0，将在add()方法内部调用dec()方法。由于dec()方法也需要获取this锁，现在问题来了：
// 对同一个线程，能否在获取到锁以后继续获取同一个锁？
// 答案是肯定的。JVM允许同一个线程重复获取同一个锁，这种能被同一个线程反复获取的锁，就叫做【可重入锁】。
// 由于Java的线程锁是可重入锁，所以，获取锁的时候，【不但要判断是否是第一次获取，还要记录这是第几次获取】。
// 每获取一次锁，记录+1，每退出synchronized块，记录-1，减到0的时候，才会真正释放锁。
class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}

// 一个线程可以获取一个锁后，再继续获取另一个锁。例如：
// public void add(int m) {
//    synchronized(lockA) { // 获得lockA的锁
//        this.value += m;
//        synchronized(lockB) { // 获得lockB的锁
//            this.another += m;
//        } // 释放lockB的锁
//    } // 释放lockA的锁
//}
//
//public void dec(int m) {
//    synchronized(lockB) { // 获得lockB的锁
//        this.another -= m;
//        synchronized(lockA) { // 获得lockA的锁
//            this.value -= m;
//        } // 释放lockA的锁
//    } // 释放lockB的锁
//}

// 在获取多个锁的时候，不同线程获取多个不同对象的锁可能导致死锁。对于上述代码，线程1和线程2如果分别执行add()和dec()方法时：
// 线程1：进入add()，获得lockA；
// 线程2：进入dec()，获得lockB。
// 随后：
// 线程1：准备获得lockB，失败，等待中；
// 线程2：准备获得lockA，失败，等待中。

// 此时，两个线程各自持有不同的锁，然后各自试图获取对方手里的锁，造成了双方无限等待下去，这就是死锁。
// 死锁发生后，没有任何机制能解除死锁，只能强制结束JVM进程。
// 因此，在编写多线程应用时，要特别注意防止死锁。因为死锁一旦形成，就只能强制结束进程。


// 那么我们应该如何避免死锁呢？答案是：线程获取锁的顺序要一致。即严格按照先获取lockA，再获取lockB的顺序，改写dec()方法如下：
//public void dec(int m) {
//    synchronized(lockA) { // 获得lockA的锁
//        this.value -= m;
//        synchronized(lockB) { // 获得lockB的锁
//            this.another -= m;
//        } // 释放lockB的锁
//    } // 释放lockA的锁
//}


// 网上资料
//  java中导致死锁的原因
//　多个线程同时被阻塞，它们中的一个或者全部都在等待某个资源被释放，而该资源又被其他线程锁定，从而导致每一个线程都得等其它线程释放其锁定的资源，造成了所有线程都无法正常结束。这是从网上其他文档看到的死锁产生的四个必要条件：
// 1、互斥使用，即当资源被一个线程使用(占有)时，别的线程不能使用
// 2、不可抢占，资源请求者不能强制从资源占有者手中夺取资源，资源只能由资源占有者主动释放。
// 3、请求和保持，即当资源请求者在请求其他的资源的同时保持对原有资源的占有。
// 4、循环等待，即存在一个等待队列：P1占有P2的资源，P2占有P3的资源，P3占有P1的资源。这样就形成了一个等待环路。
// 当上述四个条件都成立的时候，便形成死锁。当然，死锁的情况下如果打破上述任何一个条件，便可让死锁消失。
