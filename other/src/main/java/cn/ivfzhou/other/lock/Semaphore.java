package cn.ivfzhou.other.lock;

public class Semaphore {

    public static void semaphore() throws InterruptedException {
        java.util.concurrent.Semaphore s = new java.util.concurrent.Semaphore(2);
        new Thread(() -> {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
            s.release();
        }).start();
        new Thread(() -> {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(2);
            s.release();
        }).start();
        new Thread(() -> {
            try {
                s.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(3);
            s.release();
        }).start();
        s.acquire();
        s.release();
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore.semaphore();
    }

}
