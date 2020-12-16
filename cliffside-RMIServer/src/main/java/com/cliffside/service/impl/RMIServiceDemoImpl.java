package com.cliffside.service.impl;

import com.cliffside.service.RMIServiceDemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author cliffside
 * @date 2020-12-15 15:19
 *
 * UnicastRemoteObject实现该类为了序列化
 */
public class RMIServiceDemoImpl extends UnicastRemoteObject implements RMIServiceDemo {
    /**
     * 因为父类所有的构造方法都是protected的，所以这里需要重新写一个构造器
     * @throws RemoteException
     */
    public RMIServiceDemoImpl() throws RemoteException{}

    @Override
    public String demo(String param) throws RemoteException {
        return param;
    }
}
