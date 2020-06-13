package com.access.holding;

import java.nio.file.FileSystems;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ctx.start();
        System.out.println("*********");
        System.out.println("**********");
        System.out.println("----CSV 2 XML Generator started ----");
        System.out.println("----Put test file in :"+FileSystems.getDefault().getPath("").toAbsolutePath()+"/src/main/resources/input");
        System.out.println("----use ctrl+c to terminate ----");

        try {
            Thread.sleep(5 * 60 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        ctx.stop();
        ctx.close();
    }
}