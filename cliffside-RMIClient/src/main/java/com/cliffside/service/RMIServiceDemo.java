package com.cliffside.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author cliffside
 * @date 2020-12-15 15:15
 */
public interface RMIServiceDemo extends Remote {
    String demo(String param) throws RemoteException;

}
