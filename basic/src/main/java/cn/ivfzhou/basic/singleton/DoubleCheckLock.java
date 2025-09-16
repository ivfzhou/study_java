package cn.ivfzhou.basic.singleton;

public class DoubleCheckLock {

    private static volatile DoubleCheckLock instance;

    private DoubleCheckLock() {
    }

    public static DoubleCheckLock getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckLock.class) {
                if (instance == null) {
                    instance = new DoubleCheckLock();
                }
            }
        }

        return instance;
    }

}
