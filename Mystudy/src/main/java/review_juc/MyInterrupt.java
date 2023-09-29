package review_juc;

public class MyInterrupt extends Thread {
    public volatile boolean flag = false;

    @Override
    public void run() {
        while (!flag) {
            System.out.println("MyThread run...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyInterrupt t1 = new MyInterrupt();
        t1.start();

        // 主线程休眠6秒
        Thread.sleep(6000);

        // 法一：更改标记位
        t1.flag = true;

        // 法二：调用stop方法
        t1.stop();
    }

}
