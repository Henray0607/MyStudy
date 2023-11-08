package review_juc;

public class NotifyDemo {

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            // 加锁同步块，使用 lock 对象作为锁。只有一个线程可以进入这个同步块，其他线程必须等待直到锁被释放。
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    // 等待操作，它让当前线程进入等待状态，并释放 lock 锁。
                    // 线程将一直等待，直到另一个线程调用相同lock对象的notify()或notifyAll()方法，唤醒它。
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...被唤醒了...");
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "...waiting...");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...被唤醒了...");
            }
        }, "t2");

        // 调用start方法启动线程
        t1.start();
        t2.start();

        Thread.sleep(2000);

        synchronized (lock) {
            // lock.notify();
            lock.notifyAll();
        }
    }
}
