package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class Ex11 {
    public static void main(String[] args) {
        Th1 th = new Th1();
        Thread th1 = new Thread(th);
        Thread th2 = new Thread(th);
        Thread th3 = new Thread(th);
        Thread th4 = new Thread(th);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}

class MyCount {
    public static  int count = 0;
}

class Th1 implements Runnable{

    public synchronized void  countPlus(){
        MyCount.count++;
        System.out.println(MyCount.count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            countPlus();
        }
    }
}
