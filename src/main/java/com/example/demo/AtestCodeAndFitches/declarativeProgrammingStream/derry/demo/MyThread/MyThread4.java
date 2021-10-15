package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo.MyThread;

import javax.swing.*;
import java.util.ArrayList;

public class MyThread4 extends Thread{
    @Override
    public void run() {

        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("iterator i = " + i + "\n" +
                    "Thread name - " + Thread.currentThread().getName() + "\n" +
                    "Group is - " + Thread.currentThread().getThreadGroup() + "\n" +
                    "toString - " + Thread.currentThread().toString() + "\n" +
                    "getState - " + Thread.currentThread().getState()  + "\n" +
                    "getStackTrace - " + Thread.currentThread().getStackTrace()  + "\n" +
                    "getContextClassLoader - " + Thread.currentThread().getContextClassLoader()  + "\n" +
                    "-----------------------------------------------------------------\n") ;

        }

    }



}
