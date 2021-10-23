package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.MyThread;

public class Ex_Wait_Notify {
    public static void main(String[] args) throws InterruptedException {
        Market market = new Market();

        Customer customer = new Customer(market);
        Producer producer = new Producer(market);

        Thread threadCustomer = new Thread(customer);
        Thread threadProducer = new Thread(producer);

        threadCustomer.start();
        threadProducer.start();

//        threadCustomer.join();
//        threadProducer.join();

        System.out.println("Main ends");
    }
}

class Market{
    private int count_of_bread = 0;

    public synchronized void setBread(){
        while (count_of_bread >= 5){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count_of_bread++;
        System.out.println("Producer adds bread to market");
        System.out.println("count of bread (Market) = " + count_of_bread);
        notify();
    }

    public synchronized void getBread(){
        while (count_of_bread < 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count_of_bread--;
        System.out.println("Customer bay bread from market");
        System.out.println("count of bread (Market) = " + count_of_bread);
        notify();
    }
}

class Customer implements Runnable{
    Market market;

    public Customer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getBread();
        }
    }
}

class Producer implements Runnable{
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.setBread();
        }
    }
}
