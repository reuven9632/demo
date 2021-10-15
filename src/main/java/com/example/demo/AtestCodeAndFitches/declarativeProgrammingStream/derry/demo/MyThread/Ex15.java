package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex15 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Count_I());
        Thread th2 = new Thread(new Count_I());
        Thread th3 = new Thread(new Count_J());
        Thread th4 = new Thread(new Count_J());
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}


class Counts {

    public static  Object lock = new Object();
    private static volatile int i = 0;
    private static volatile int j = 0;


    public void countOf_I(){
        synchronized (lock){
            i++;
            System.out.println("i = [" + i + "]         " + Thread.currentThread().getName());
        }
    }

    public void countOf_J(){
        synchronized (lock){
            j++;
            System.out.println("j = [" + j + "] *" + Thread.currentThread().getName());
        }
    }

}

class Count_I implements Runnable{

    @Override
    public void run() {
        Counts count = new Counts();
        for (int i = 0; i < 30; i++) {
            count.countOf_I();
        }
    }
}

class Count_J implements Runnable{

    @Override
    public void run() {
        Counts count = new Counts();
        for (int i = 0; i < 40; i++) {
            count.countOf_J();
        }
    }
}
