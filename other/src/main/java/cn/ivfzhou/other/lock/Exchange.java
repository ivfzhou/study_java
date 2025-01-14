package cn.ivfzhou.other.lock;

import java.util.concurrent.Exchanger;

public class Exchange {

    public static void exchange() {
        Exchanger<String> e = new Exchanger<>();
        new Thread(() -> {
            try {
                System.out.println("1: " + e.exchange("1"));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println("2: " + e.exchange("2"));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        Exchange.exchange();
        Thread.sleep(100L);
    }

}
