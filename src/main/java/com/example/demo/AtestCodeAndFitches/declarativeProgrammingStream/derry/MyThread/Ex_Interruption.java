package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class Ex_Interruption {
    public static void main(String[] args) throws InterruptedException {
        CountSQRT thread = new CountSQRT();
        thread.start();
        Thread.sleep(200);
        thread.interrupt();


        thread.join();
        System.out.println("main is ends");
    }
}

class CountSQRT extends Thread{
    private double countSQRT;


    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {

            if (isInterrupted()){
                System.out.println("Someone wants to stop this Thread");
                System.out.println("We ends all functions and finish this Thread");
                System.out.println(countSQRT);
                return;
            }


            countSQRT+=Math.sqrt(i);


            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Someone wants to stop this Thread when we sleep");
                System.out.println(countSQRT);
                System.out.println("We go out from Thread");
                return;
            }

        }
        System.out.println(countSQRT);
    }
}
