package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.derry.demo;

import com.example.demo.MyThread.MyThread;
import com.example.demo.MyThread.MyThread3;
import com.example.demo.MyThread.MyThread4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		MyThread4 myThread4 = new MyThread4();
		myThread4.setName("myThread");
		myThread4.setPriority(Thread.MIN_PRIORITY);
//		System.out.println(myThread4.getThreadGroup());
		System.out.println(myThread4.getContextClassLoader());
		System.out.println(myThread4.getStackTrace());
		myThread4.start();


		try {
			myThread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("end of main");



		/*
		*//*-------------------------------------*//*
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("jast do it: nike");
			}
		}).start();
		*//*-------------------------------------*//*

		new Thread(() -> System.out.println("adidas")).start();

		*//*-------------------------------------*//*

		new MyThread().start();


		*//*-------------------------------------*//*

		Thread thread = new Thread(new MyThread3());
		thread.start();
		System.out.println(
				"Thread has name = " + thread.getName() +
						" has getPriority " + thread.getPriority()
		);

		*//*-------------------------------------*//*

		MyThread4 myThread4 = new MyThread4();
		System.out.println(
				"MyThread4 has name = " + myThread4.getName() +
						" has getPriority " + myThread4.getPriority()
		);


		MyThread4 myThread41 = new MyThread4();
		myThread41.setName("myThread41-name");
		myThread41.setPriority(Thread.MAX_PRIORITY);
		System.err.println(myThread41);
		System.out.println(
				"MyThread41 has name = " + myThread41.getName() +
						" has getPriority " + myThread41.getPriority()
		);
*/

	}
}
