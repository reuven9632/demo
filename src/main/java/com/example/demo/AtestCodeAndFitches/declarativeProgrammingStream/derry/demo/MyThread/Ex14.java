package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex14 {
    public static void main(String[] args) {
       /* Th3 th3 = new Th3();
        Thread thread = new Thread(th3);
        thread.start();
        Thread thread2 = new Thread(th3);
        thread2.start();
        Thread thread3 = new Thread(th3);
        thread3.start();*/

        Thread thread = new Thread(new Th3());
        thread.start();
        Thread thread2 = new Thread(new Th3());
        thread2.start();
        Thread thread3 = new Thread(new Th3());
        thread3.start();

    }

}


class Count1{
    public static int count = 0;
}


/**
 * this is my thread
 *
 * */
class Th3 implements Runnable{

    public static volatile Object lock = new Object();

    public void work1(){
        work2();
        synchronized (lock){
            Count1.count++;
            System.out.println("[" + Count1.count + "]");
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void work2(){
        System.out.println("yahoooooooooooooo");
    }


    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            work1();
        }
    }
}
