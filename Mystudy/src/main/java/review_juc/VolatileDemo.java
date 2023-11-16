package review_juc;

public class VolatileDemo {
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

        new Thread(() -> {
            int i = 0;
            // JIT
            while (!stop) {
                i++;
            }
            System.out.println("stopped... c:" + i);
        }, "t3").start();
    }
}
