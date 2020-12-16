package com.cliffside;

import com.cliffside.service.impl.RMIServiceDemoImpl;

import java.io.PrintStream;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @author cliffside
 * @date 2020-12-15 15:24
 */
public class RMIServer {
    public static void main(String[] args) {
        try {
            //创建接口实例
            RMIServiceDemoImpl rmiServiceDemo = new RMIServiceDemoImpl();
            //创建注册表
            LocateRegistry.createRegistry(8989);
            //绑定服务
            Naming.bind("rmi://localhost:8989/rmiServiceDemo",rmiServiceDemo);
            System.out.println("服务器启动成功");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }


    }


}
