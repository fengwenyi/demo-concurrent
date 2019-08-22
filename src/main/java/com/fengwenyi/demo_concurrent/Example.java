package com.fengwenyi.demo_concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Erwin Feng
 * @since 2019/8/22 17:26
 */
public class Example {

    public static void main(String[] args) {
        final CountDownLatch begin = new CountDownLatch(1);

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            final int NO = i + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        begin.await();
                        System.out.println("第 " + NO + " 条数据开始执行");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 相当于：同时有10个客户端请求，每个客户端发送10条数据（总共发送100条数据）
            executorService.submit(run);
        }

        System.out.println("开始执行......");
        begin.countDown();
        executorService.shutdown();

/*
开始执行
第 2 条数据开始执行
第 11 条数据开始执行
第 12 条数据开始执行
第 13 条数据开始执行
第 14 条数据开始执行
第 15 条数据开始执行
第 16 条数据开始执行
第 17 条数据开始执行
第 18 条数据开始执行
第 19 条数据开始执行
第 20 条数据开始执行
第 21 条数据开始执行
第 22 条数据开始执行
第 23 条数据开始执行
第 24 条数据开始执行
第 1 条数据开始执行
第 4 条数据开始执行
第 27 条数据开始执行
第 28 条数据开始执行
第 29 条数据开始执行
第 30 条数据开始执行
第 31 条数据开始执行
第 25 条数据开始执行
第 33 条数据开始执行
第 34 条数据开始执行
第 35 条数据开始执行
第 36 条数据开始执行
第 37 条数据开始执行
第 38 条数据开始执行
第 39 条数据开始执行
第 40 条数据开始执行
第 41 条数据开始执行
第 42 条数据开始执行
第 43 条数据开始执行
第 6 条数据开始执行
第 45 条数据开始执行
第 46 条数据开始执行
第 47 条数据开始执行
第 48 条数据开始执行
第 49 条数据开始执行
第 50 条数据开始执行
第 51 条数据开始执行
第 52 条数据开始执行
第 53 条数据开始执行
第 54 条数据开始执行
第 55 条数据开始执行
第 56 条数据开始执行
第 57 条数据开始执行
第 58 条数据开始执行
第 59 条数据开始执行
第 60 条数据开始执行
第 61 条数据开始执行
第 62 条数据开始执行
第 63 条数据开始执行
第 64 条数据开始执行
第 65 条数据开始执行
第 66 条数据开始执行
第 67 条数据开始执行
第 68 条数据开始执行
第 69 条数据开始执行
第 70 条数据开始执行
第 71 条数据开始执行
第 72 条数据开始执行
第 73 条数据开始执行
第 74 条数据开始执行
第 75 条数据开始执行
第 76 条数据开始执行
第 77 条数据开始执行
第 78 条数据开始执行
第 79 条数据开始执行
第 80 条数据开始执行
第 81 条数据开始执行
第 82 条数据开始执行
第 83 条数据开始执行
第 84 条数据开始执行
第 85 条数据开始执行
第 86 条数据开始执行
第 87 条数据开始执行
第 88 条数据开始执行
第 89 条数据开始执行
第 90 条数据开始执行
第 91 条数据开始执行
第 92 条数据开始执行
第 93 条数据开始执行
第 94 条数据开始执行
第 95 条数据开始执行
第 3 条数据开始执行
第 97 条数据开始执行
第 98 条数据开始执行
第 99 条数据开始执行
第 100 条数据开始执行
第 96 条数据开始执行
第 10 条数据开始执行
第 9 条数据开始执行
第 8 条数据开始执行
第 7 条数据开始执行
第 44 条数据开始执行
第 5 条数据开始执行
第 32 条数据开始执行
第 26 条数据开始执行
*/
    }

}
