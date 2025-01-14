package cn.ivfzhou.other.lock;

public class Phaser {

    public static void phaser() {
        java.util.concurrent.Phaser p = new java.util.concurrent.Phaser(2);
        new Thread(() -> {
            System.out.println("1");
            p.arrive();
        }).start();
        new Thread(() -> {
            System.out.println("2");
            p.arrive();
        }).start();
        p.awaitAdvance(2);
    }

    public static void main(String[] args) {
        Phaser.phaser();
    }

}
