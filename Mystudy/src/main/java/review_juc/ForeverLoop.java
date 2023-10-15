package review_juc;

/**
 * 可见性案例
 */
public class ForeverLoop {
    // 对多个线程的可见性
    // public static boolean stop = false;
    public static volatile boolean stop = false;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop = true;
            System.out.println(Thread.currentThread().getName() + ": modify stop to true...");
        }, "t1").start();

        new Thread(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + stop);
        }, "t2").start();

        // VM Options配置参数:-Xint 禁用即时编译器
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
            System.out.println("stopped... count: " + i);
        }, "t3").start();
    }
}
