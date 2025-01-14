package cn.ivfzhou.other.lock;

public class CountDownLatch {

    public static void countDownLatch() throws InterruptedException {
        java.util.concurrent.CountDownLatch cdl = new java.util.concurrent.CountDownLatch(2);
        new Thread(() -> {
            System.out.println("1 done");
            cdl.countDown();
        }).start();
        new Thread(() -> {
            System.out.println("2 done");
            cdl.countDown();
        }).start();
        cdl.await();
    }

    public static void join() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("1 done");
        });
        Thread thread1 = new Thread(() -> {
            System.out.println("2 done");
        });
        thread.start();
        thread1.start();
        thread1.join();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch.countDownLatch();
        CountDownLatch.join();
    }

}
