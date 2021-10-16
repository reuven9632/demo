package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("hello");
        int i = 0;
        while (i < 100)
            System.out.println(  i < 100 ? i++ : i);
        MyThread2 thread2 = new MyThread2();
        thread2.start();

    }
}
