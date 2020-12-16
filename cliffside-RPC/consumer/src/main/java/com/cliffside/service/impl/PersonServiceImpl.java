package com.cliffside.service.impl;

import com.cliffside.pojo.Person;
import com.cliffside.service.MyPersonService;
import com.cliffside.service.PersonService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.util.List;

/**
 * @author cliffside
 * @date 2020-12-16 18:43
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> show() {
        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper("124.70.38.220:2181", 100000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("连接zookeeper成功");
                }
            });
            byte[] data = zooKeeper.getData("/RPC/provider", false, null);

            MyPersonService myPersonService = (MyPersonService)Naming.lookup(new String(data));

            return  myPersonService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
