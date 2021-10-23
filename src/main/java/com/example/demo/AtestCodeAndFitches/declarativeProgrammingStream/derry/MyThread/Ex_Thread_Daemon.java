package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class Ex_Thread_Daemon {
    public static void main(String[] args) throws InterruptedException {
        Thread thread_Ex9 = new Thread(new Thread_1());
        thread_Ex9.start();
        thread_Ex9.join();

        Thread thread_TelephoneCall = new Thread(new TelephoneCall());
        thread_TelephoneCall.setDaemon(true);
        thread_TelephoneCall.start();

        System.out.println("main wait 2 sec");
        Thread.sleep(2000);
        System.out.println("main end work!");
    }







}

class Thread_1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread starts!!");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ends " + Thread.currentThread().getName());
    }
}
