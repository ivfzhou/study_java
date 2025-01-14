package cn.ivfzhou.java.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZooKeeperPool {

    public static CuratorFramework cf() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 2);
        CuratorFramework cf = CuratorFrameworkFactory.builder()
                .connectString("127.0.0.1:12181,127.0.0.1:22182,127.0.0.1:22183")
                .retryPolicy(retryPolicy)
                .build();
        cf.start();
        return cf;
    }

}
