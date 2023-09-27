package review_juc;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * wait() 方法的调用必须先获取 wait() 对象的锁，而 sleep() 则无此限制
 * wait() 方法执行后会释放对象锁，允许其它线程获得该对象锁(我放弃 cpu，但你们还可以用)
 * sleep() 如果在 synchronized 代码块中执行，并不会释放对象锁 (我放弃 cpu，你们也用不了)
 */
public class WaitSleepDemo {
    public static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        // illegalWait();
        // waiting();
        sleeping();
    }

    private static void illegalWait() throws InterruptedException {
        synchronized (LOCK) {
            LOCK.wait();
        }
    }

    private static void waiting() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    String starTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    System.out.println(starTime + "waiting...");
                    LOCK.wait(5000L);
                    String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    System.out.println(endTime + "running...end");
                } catch (InterruptedException e) {
                    System.out.println("interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            String currentTimeMillis = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(currentTimeMillis + "other...");
        }
    }

    private static void sleeping() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (LOCK) {
                try {
                    String currentTimeMillis = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                    System.out.println(currentTimeMillis + "sleeping...");
                    LOCK.wait(5000L);
                } catch (InterruptedException e) {
                    System.out.println("interrupted...");
                    e.printStackTrace();
                }
            }
        }, "t1");
        t1.start();

        Thread.sleep(100);
        synchronized (LOCK) {
            String currentTimeMillis = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.out.println(currentTimeMillis + "other...");
        }
    }

}
