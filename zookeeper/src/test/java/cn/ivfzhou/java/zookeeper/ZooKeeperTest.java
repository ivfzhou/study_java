package cn.ivfzhou.java.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.junit.Test;

public class ZooKeeperTest {

    private final org.apache.zookeeper.ZooKeeper zk = ZooKeeper.create();

    public ZooKeeperTest() throws IOException {
    }

    // 创建一个目录节点
    @Test
    public void testCreate() throws InterruptedException, KeeperException {
        zk.create("/test_path", "test_data".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void testExist() throws InterruptedException, KeeperException {
        System.out.println(zk.exists("/test_path", false));
    }

    @Test
    public void testGetData() throws InterruptedException, KeeperException {
        System.out.println(new String(zk.getData("/test_path", false, null)));
    }

    @Test
    public void testSetData() throws InterruptedException, KeeperException {
        zk.setData("/test_path", "test_data".getBytes(), -1);
    }

    @Test
    public void testDelete() throws InterruptedException, KeeperException {
        zk.delete("/test_path", -1);
    }

    @Test
    public void testClose() throws InterruptedException {
        zk.close();
    }

}