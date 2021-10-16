package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class Ex16 {
    public static void main(String[] args) {
        Thread thread = new Thread(new TelephoneCall());
        Thread thread1 = new Thread(new ViberCall());
        Thread thread2 = new Thread(new WhatsAppCall());
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class Calls{
    public static Object lock = new Object();

    public static void MultiCall(String nameAPP, long millis){
        synchronized (lock) {
            System.out.println(String.format("call on %s starts...", nameAPP));
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s call ends.", nameAPP));
        }

    }

    /*public void CallTelephone(){
        System.out.println("call on telephone starts...");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("telephone call ends.");
    }

    public void CallViber(){
        System.out.println("call on VIBER starts***");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("                VIBER call ends***");
    }

    public void CallTelegram(){
        System.out.println("call on Telegram starts___");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("                                      Telegram call ends___");
    }*/

}

class TelephoneCall implements Runnable{
    @Override
    public void run() {
        Calls.MultiCall("Telephone", 2500);
    }
}

class ViberCall implements Runnable{
    @Override
    public void run() {
        Calls.MultiCall("VIBER", 5000);
    }
}

class WhatsAppCall implements Runnable{
    @Override
    public void run() {
        Calls.MultiCall("WhatsApp", 8000);
    }
}