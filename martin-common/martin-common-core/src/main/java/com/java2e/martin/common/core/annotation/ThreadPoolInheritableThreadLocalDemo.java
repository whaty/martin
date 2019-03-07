package com.java2e.martin.common.core.annotation;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import sun.rmi.runtime.Log;

import java.lang.instrument.Instrumentation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: liangcan
 * @version: 1.0
 * @date: 2019/3/6
 * @describtion: ThreadPoolInheritableThreadLocalDemo
 */
public class ThreadPoolInheritableThreadLocalDemo {

//    static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
//    static ExecutorService pool = Executors.newFixedThreadPool(2);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
            System.out.println("executorService = " + executorService);
        });
        String s = "123";
        System.out.println("args = " + s);
    }

}