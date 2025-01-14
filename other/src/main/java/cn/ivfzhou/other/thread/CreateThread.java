package cn.ivfzhou.other.thread;

public class CreateThread {

    static class ExtendsThread extends Thread {
        @Override
        public void run() {
            System.out.println("重写run方法");
        }
    }

    static void create1() {
        Thread thread = new ExtendsThread();
        thread.start();
    }

    static class ImplementsRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("实现run方法");
        }
    }

    static void create2() {
        Thread thread = new Thread(new ImplementsRunnable());
        thread.start();
    }

    public static void main(String[] args) {
        create1();
        create2();
    }

}
