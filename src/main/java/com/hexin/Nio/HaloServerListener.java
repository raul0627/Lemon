package com.hexin.Nio;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2015/12/10.
 */
public class HaloServerListener implements ServletContextListener{
    private HaloServer haloServer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized start");
        haloServer = new HaloServer();
        Thread haloserver = new Thread(haloServer);
        haloserver.setDaemon(true);
        haloserver.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed start");
        if (haloServer != null) {
            System.out.println("stop haloServer");
            haloServer.stop();
        }
        /*try {
            System.out.println("deregisterDriver start");
            DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            System.out.println("deregisterDriver end");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
