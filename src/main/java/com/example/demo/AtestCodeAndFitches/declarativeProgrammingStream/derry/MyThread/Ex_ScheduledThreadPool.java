package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ex_ScheduledThreadPool{
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(3);

        /*for (int i = 0; i < 8; i++) {
            scheduledExecutorService.schedule(new ScheduledThreadPool(), 3, TimeUnit.SECONDS);  //make delay for starting of threadPool
        }

        scheduledExecutorService.shutdown();                                    //need to end scheduledExecuteService
        scheduledExecutorService.awaitTermination(5, TimeUnit.SECONDS); //like thread.join
        System.out.println("------------  main ends  --------------");*/

        //or use .scheduleAtFixedRate (name Thread, delay, period of task working, TimeUnit)
        System.out.println("------------------------------------------------------------------------------------\n");
        scheduledExecutorService.scheduleAtFixedRate(new ScheduledThreadPool(), 4, 2, TimeUnit.SECONDS);

        Thread.sleep(20000);
        scheduledExecutorService.shutdown();

        Thread.sleep(800);
        System.out.println("------------  main ends  --------------");


    }
}

class ScheduledThreadPool implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "  --   ScheduledThreadPool START");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "  --   ScheduledThreadPool ENDs");
    }
}
