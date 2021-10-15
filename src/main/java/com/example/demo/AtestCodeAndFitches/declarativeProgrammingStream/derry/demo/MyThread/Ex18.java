package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex18 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Pipi());
        Thread thread2 = new Thread(new Kaka());
        thread1.start();
        thread2.start();

    }
}

interface Body{
    void pipi();
    void kaka();
}

class BodyImp implements Body{
    public static Object lock = new Object();

    @Override
    public void pipi() {
        synchronized(lock){
            System.out.println("start do pipi");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end pipi. OUUUUUHHHHH eeeeeaaaaa    goood");
        }
    }

    @Override
    public void kaka() {
        synchronized(lock){
            System.out.println("I NEED KAKA!!!!! START");
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SOOO GOOD I FINISHED KAKA!!!!");
        }
    }


}

class Pipi implements Runnable{
    @Override
    public void run() {
        BodyImp bodyImp = new BodyImp();
        bodyImp.pipi();
    }
}

class Kaka implements Runnable{
    @Override
    public void run() {
        BodyImp bodyImp = new BodyImp();
        bodyImp.kaka();
    }
}