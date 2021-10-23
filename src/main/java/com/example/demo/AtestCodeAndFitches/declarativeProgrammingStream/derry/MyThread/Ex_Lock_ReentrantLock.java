package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex_Lock_ReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Thread thread = new Thread(new Employee("Yuri", lock));
        Thread thread1 = new Thread(new Employee("Gena", lock));
        Thread thread2 = new Thread(new Employee("Mila", lock));
        Thread thread3 = new Thread(new Employee("Lena", lock));
        Thread thread4 = new Thread(new Employee("Vitolda", lock));
        Thread thread5 = new Thread(new Employee("Ruti", lock));
        Thread thread6 = new Thread(new Employee("Meni", lock));
        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(3000);
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

class Employee implements Runnable{
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println(name + "wait to use bankomat...  ... . . .");
        if (lock.tryLock()){
            System.out.println(name + " USING bankomat");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
            System.out.println(name + "ENDS using !!!\n");
        }

        System.out.println(name + "do not want wait, he/she goes home----->>>");
    }
}
