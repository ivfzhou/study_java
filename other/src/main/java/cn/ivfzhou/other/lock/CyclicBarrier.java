package cn.ivfzhou.other.lock;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {

    public static void cyclicBarrier() {
        java.util.concurrent.CyclicBarrier cb = new java.util.concurrent.CyclicBarrier(2);
        new Thread(() -> {
            try {
                System.out.println("1 wait");
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("1 done");
        }).start();
        new Thread(() -> {
            try {
                System.out.println("2 wait");
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("2 done");
        }).start();
    }

    public static void main(String[] args) {
        CyclicBarrier.cyclicBarrier();
    }

}
