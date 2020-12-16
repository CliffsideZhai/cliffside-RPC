package com.cliffside.serviceImpl;

import com.cliffside.pojo.Person;
import com.cliffside.service.MyPersonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cliffside
 * @date 2020-12-16 17:29
 * 实现service的方法
 */
public class MyPersonServiceImpl extends UnicastRemoteObject implements MyPersonService {

    public MyPersonServiceImpl() throws RemoteException {
    }

    @Override
    public List<Person> findAll() throws RemoteException {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person(1,"zhangsan"));
        people.add(new Person(2,"lisi"));

        return people;
    }
}
