package com.cliffside;

import com.cliffside.service.RMIServiceDemo;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author cliffside
 * @date 2020-12-15 15:57
 */
public class RMIClient {
    public static void main(String[] args){
        try {
            RMIServiceDemo rmiServiceDemo = (RMIServiceDemo)Naming.lookup("rmi://localhost:8989/rmiServiceDemo");

            String cliffside = rmiServiceDemo.demo("cliffside");

            System.out.println(cliffside);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
