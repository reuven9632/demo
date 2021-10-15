package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex17 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Eat());
        Thread thread2 = new Thread(new Speak());
        thread1.start();
        thread2.start();
    }
}

class BodyFunctions{
    public static Object lock = new Object();

    public static  void toEat(){
        synchronized (lock){
            System.out.println("start eat");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end eat");
        }
    }


    public static void toSpeak(){
        synchronized (lock){
            System.out.println("START SPEAK");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("END SPEAK");
        }
    }
}

class Speak implements Runnable{
    @Override
    public void run() {
        BodyFunctions.toSpeak();
    }
}

class Eat implements Runnable{
    @Override
    public void run() {
        BodyFunctions.toEat();
    }
}