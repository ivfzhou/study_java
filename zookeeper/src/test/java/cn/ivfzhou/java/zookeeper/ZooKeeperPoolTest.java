package cn.ivfzhou.java.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class ZooKeeperPoolTest {

    CuratorFramework cf = ZooKeeperPool.cf();

    // 获取子节点
    @Test
    public void testGetChildren() throws Exception {
        List<String> strings = cf.getChildren().forPath("/");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    // 获取节点数据
    @Test
    public void testGetData() throws Exception {
        byte[] bytes = cf.getData().forPath("/test_path");
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    // 添加
    @Test
    public void testCreate() throws Exception {
        cf.create().withMode(CreateMode.PERSISTENT).forPath("/test_path", "test_data".getBytes());
    }

    // 修改
    @Test
    public void testUpdate() throws Exception {
        cf.setData().forPath("/test_path", "test_data".getBytes());
    }

    // 删除
    @Test
    public void testDelete() throws Exception {
        cf.delete().deletingChildrenIfNeeded().forPath("/test_path");
    }

    // 查看znode的状态
    @Test
    public void testStat() throws Exception {
        Stat stat = cf.checkExists().forPath("/test_path");
        System.out.println(stat);
    }

    // 监听通知机制
    @Test
    public void testListen() throws Exception {
        // 1. 创建NodeCache对象，指定要监听的znode
        NodeCache nodeCache = new NodeCache(cf, "/test_path");
        nodeCache.start();
        // 2. 添加一个监听器
        nodeCache.getListenable().addListener(() -> {
            byte[] data = nodeCache.getCurrentData().getData();
            Stat stat = nodeCache.getCurrentData().getStat();
            String path = nodeCache.getCurrentData().getPath();
            System.out.println("监听的节点是：" + path);
            System.out.println("节点现在的数据是：" + new String(data, StandardCharsets.UTF_8));
            System.out.println("节点状态是：" + stat);
        });
        System.out.println("开始监听！！");
        // 3. System.in.read();
        System.in.read();
    }

}
