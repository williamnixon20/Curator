package org.example;
import org.apache.curator.*;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.log4j.BasicConfigurator;
import org.apache.zookeeper.ZooKeeper;

import java.nio.charset.StandardCharsets;


public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        int sleepMsBetweenRetries = 100;
        int maxRetries = 5;
        System.setProperty("java.security.auth.login.config", "C:\\Users\\ASUS\\Desktop\\curator2\\src\\main\\java\\org\\example\\client.jaas");
        System.setProperty("curator-log-events", "true");
        RetryPolicy retryPolicy = new RetryNTimes(
                maxRetries, sleepMsBetweenRetries);
        CuratorFramework client = CuratorFrameworkFactory
                .newClient("128.199.69.141:2181", retryPolicy);
        client.start();
        try {
            client.create().forPath("/my/path", "hiii".getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {

        }
        while (true);
    }
}