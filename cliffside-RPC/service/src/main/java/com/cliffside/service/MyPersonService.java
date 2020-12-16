package com.cliffside.service;

import com.cliffside.pojo.Person;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author cliffside
 * @date 2020-12-16 17:23
 */
public interface MyPersonService extends Remote {
    /**
     * RMI的接口需要继承Remote 以及抛出 RemoteException；
     * @return
     * @throws RemoteException
     */
    public List<Person> findAll() throws RemoteException;

}
