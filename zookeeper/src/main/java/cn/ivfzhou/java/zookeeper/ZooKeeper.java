package cn.ivfzhou.java.zookeeper;

import java.io.IOException;

public class ZooKeeper {

    public static org.apache.zookeeper.ZooKeeper create() throws IOException {
        return new org.apache.zookeeper.ZooKeeper("127.0.0.1:2181", 1000, null);
    }

}
