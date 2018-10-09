package com.zqb.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.zqb.bean.Goods;
import com.zqb.common.BaseException;
import com.zqb.common.ReturnObject;
import com.zqb.service.GoodsService;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * Copyright © 2012-2050,dajia Co.,Ltd. All rights reserved.
 * This program is protected by copyright laws;
 * <p>
 * Program Name: shopping-mall
 * <p>
 * Description:
 * <p>
 * Created by zengqb on 2018/7/25
 *
 * @author zengqb
 * @version 1.0
 */
@RequestMapping("/sm/goods")
@Controller
public class SMGoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        System.out.println("CPU个数:"+ Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 3; i++) {
            executorService.execute(myTask);
        }
        executorService.shutdown();
    }

    @GetMapping("/insertGoods")
    @ResponseBody
    public ReturnObject insertGoods() throws BaseException {
        ReturnObject ro = new ReturnObject();
        Goods goods = new Goods("商品1", 100, 50);
        goodsService.insertGoods(goods);
        ro.setSuccess(true);
        return ro;

    }


//    public static void main(String[] args){
////        printGroupInfo(Thread.currentThread());
//        Thread appThread = new Thread(new Runnable(){
//            public volatile int testValue;
//            @Override
//            public void run() {
////                for (int i=0;i<5;i++) {
//                System.out.println(Thread.currentThread().getName());
//                   if (Thread.currentThread().getName().equalsIgnoreCase("appThread-1")) {
//                       testValue = testValue + 10;
//                   } else if (Thread.currentThread().getName().equalsIgnoreCase("appThread-2")) {
//                       System.out.println("testValue:" + testValue);
//                   }
////                }
//            }
//        });
////        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("appThread-%d").build();
//        ExecutorService singleThreadPool = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024), new ThreadPoolExecutor.AbortPolicy());
//        for (int i = 0; i < 10; i++) {
//            singleThreadPool.execute(appThread);
//        }
//        singleThreadPool.shutdown();
//
////        printGroupInfo(appThread);
//    }
//
//    static void printGroupInfo(Thread t) {
//        ThreadGroup group = t.getThreadGroup();
//        System.out.println("thread " + t.getName() + " group name is "
//                + group.getName()+ " max priority is " + group.getMaxPriority()
//                + " thread count is " + group.activeCount());
//
//        ThreadGroup parent=group;
//        do {
//            ThreadGroup current = parent;
//            parent = parent.getParent();
//            if (parent == null) {
//                break;
//            }
//
//            System.out.println(current.getName() + "'s parent is " + parent.getName());
//        } while (true);
//        System.out.println("--------------------------");
//    }

    /**
     * 定义静态内部线程类
     */
    public static class MyTask implements Runnable {

        public int testValue;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    if (Thread.currentThread().getName().equalsIgnoreCase("demo-pool-0")) {
                        testValue = 10 + i;
                    } else if (Thread.currentThread().getName().equalsIgnoreCase("demo-pool-1")) {
                        System.out.println("testValue:" + testValue);
                    } else {
                        System.out.println("testValue:" + testValue);
                    }
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class MultiThreadingExample implements Runnable {

        private int testValue;

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);

                    if (Thread.currentThread().getName().equalsIgnoreCase("T1")) {
                        testValue = 10 + i;
                    }
                    if (Thread.currentThread().getName().equalsIgnoreCase("T2")) {
                        System.out.println("Test value: " + testValue);
                    }

                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
//
//    public static void main(String[] args) {
//
//        MultiThreadingExample volatileExample = new MultiThreadingExample();
//
//        Thread t1 = new Thread(volatileExample, "T1");
//        Thread t2 = new Thread(volatileExample, "T2");
//
//        t1.start();
//        t2.start();
//
//    }

}
