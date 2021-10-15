package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex1 {
    public static void main(String[] args) {
//        Th th = new Th();
        Thread th1 = new Thread(new Th());
        Thread th2 = new Thread(new Th());
        Thread th3 = new Thread(new Th());
        th1.start();
        th2.start();
        th3.start();

        try {
            th1.join();
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Th.count);


    }
}
class Th implements Runnable {

    public static volatile int count = 0;

    public void plusOneToCount(){
        synchronized (this){
            count++;
            System.out.println(count + "    " + Thread.currentThread().getName() + "end");
        }
    }

    @Override
    public void run() {
        plusOneToCount();
    }
}
