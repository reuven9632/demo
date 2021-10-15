package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex12 {
    static int count = 0;
    public synchronized static void increment(){
        count++;
        System.out.print("[" + count + "]" + Thread.currentThread().getName() + "   ");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread th = new Thread(new Th2());
        Thread th1 = new Thread(new Th2());
        Thread th2 = new Thread(new Th2());
        th.start();
        th1.start();
        th2.start();
        th.join();
        th1.join();
        th2.join();
        System.out.println(count);
    }
}

class Th2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Ex12.increment();
            System.out.println("iteration #" + i);
        }
    }
}
