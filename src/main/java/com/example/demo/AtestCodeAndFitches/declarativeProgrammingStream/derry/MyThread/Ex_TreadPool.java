package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ex_TreadPool {
    public static void main(String[] args) throws InterruptedException {
        /**
         * ExecutorService executorService = new ThreadPoolExecutor();     //Do not make ThreadPool like this!!!
         * */

        /**
         * make threadPool with 5 threads on it
         * */
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new TreadPool());
        }
        executorService.shutdown();                                     //need to stop ThreadPool, if not -> main is not ends
        executorService.awaitTermination(1, TimeUnit.SECONDS);  //like method thread.join wait end of threadPool or end of time in parameter
        System.out.println("Main ends");
    }
}

class TreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
