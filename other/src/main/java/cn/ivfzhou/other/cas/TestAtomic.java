package cn.ivfzhou.other.cas;

public class TestAtomic {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Atomic.longAdder());
        System.out.println(Atomic.atomicLong());
        System.out.println(Atomic.plus());
        System.out.println(Atomic.string());
        Thread.sleep(2000L);
    }

}
