package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

public class Ex13 {
    private static Object lock = new Object();
    public static void Call(){
        synchronized(lock){
            System.out.println("Starts CALL....");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CALL is end ");
        }

    }

    public static void WhatsApp() {
        synchronized(lock) {
            System.out.println("Starts call on WhatsAPP....     trrrrrrrrrrrt trrrrrrrrrrrrrrr");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WhatsAPP call is end  -------    tuuuuu      tuuuuuu ");
        }
    }

    public static void Viber() {
        synchronized(lock) {
            System.out.println("*Starts call on Viber*************");
            try {
                Thread.sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("*Viber call is end  -------    tuuuuu      tuuuuuu   ****************** ");
        }
    }

    public static void main(String[] args) {
        Thread call = new Thread(new ThCall());
        Thread whatsApp = new Thread(new ThWhatsApp());
        Thread viber = new Thread(new ThViber());
        call.start();
        whatsApp.start();
        viber.start();
    }
}

class ThCall implements Runnable{
    @Override
    public void run() {
        Ex13.Call();
    }
}

class ThWhatsApp implements Runnable{
    @Override
    public void run() {
        Ex13.WhatsApp();
    }
}

class ThViber implements Runnable{
    @Override
    public void run() {
        Ex13.Viber();
    }
}