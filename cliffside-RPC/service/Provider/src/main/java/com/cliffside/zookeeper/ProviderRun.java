package com.cliffside.zookeeper;

import com.cliffside.service.MyPersonService;
import com.cliffside.serviceImpl.MyPersonServiceImpl;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author cliffside
 * @date 2020-12-16 17:32
 */
public class ProviderRun {
    public static void main(String[] args) {
        try {
            MyPersonService myPersonService = new MyPersonServiceImpl();

            LocateRegistry.createRegistry(8989);

            String url = "rmi://localhost:8989/myPersonService";
            Naming.bind(url,myPersonService);

            System.out.println("服务启动成功");

            //发送到zookeeper

            ZooKeeper zooKeeper = new ZooKeeper("124.70.38.220:2181", 200000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("建立连接");
                }
            });

            String s = zooKeeper.create("/RPC/provider", url.getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.PERSISTENT);
            System.out.println(s);
            System.out.println("注册zookeeper成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
