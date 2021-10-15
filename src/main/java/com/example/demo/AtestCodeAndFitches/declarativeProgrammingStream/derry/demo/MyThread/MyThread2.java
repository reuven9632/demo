package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class MyThread2 extends Thread{

    @Override
    public void run() {
        int i =10000;
        String finish = "finish";
        while (i< 10251)
            System.out.println( i < 10251 ? i++ : finish);
        System.out.println(finish);
    }
}
