package cn.ivfzhou.other.cas;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Atomic {

    private static final LongAdder count = new LongAdder();

    private static final AtomicLong count1 = new AtomicLong();

    private static long count2;

    private static final int total = 100000;


    public static long longAdder() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            new Thread(count::increment).start();
        }
        return System.currentTimeMillis() - start;
    }

    public static long atomicLong() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            new Thread(count1::incrementAndGet).start();
        }
        return System.currentTimeMillis() - start;
    }

    public static long plus() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < total; i++) {
            new Thread(() -> {
                synchronized (Atomic.class) {
                    count2++;
                }
            }).start();
        }
        return System.currentTimeMillis() - start;
    }

    public static String string() {
        return count + "-" + count1 + "-" + count2;
    }

}
