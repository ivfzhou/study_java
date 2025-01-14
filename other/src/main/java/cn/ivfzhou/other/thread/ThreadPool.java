package cn.ivfzhou.other.thread;

import java.util.concurrent.*;

public class ThreadPool {

    static void executors() throws ExecutionException, InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(
                10,
                20,
                1000,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        Future<String> res = pool.submit(() -> "callable");
        System.out.println(res.get());
        pool.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        executors();
    }

}
