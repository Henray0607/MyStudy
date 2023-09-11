package review_juc;

public class TicketDemo {
    public static final Object lock = new Object();
    int ticketNum = 10;

    public void getTicket() {
        synchronized (lock) {
            if (ticketNum <= 0) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + "抢到一张票，剩余：" + ticketNum);
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        final TicketDemo ticketDemo = new TicketDemo();
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                ticketDemo.getTicket();
            }).start();
        }
    }
}
