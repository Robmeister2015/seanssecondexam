package concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	public static void main(String[] args) throws InterruptedException{
		
		/*
		 * The countdown latch has 5 counters
		 * Each thread takes this counter in their constructor
		 */
		CountDownLatch counter = new CountDownLatch(5);
		
		Thread carlThread = new Thread(new Runner(counter));
		carlThread.setName("Carl");
		carlThread.start();
		Thread joeThread = new Thread(new Runner(counter));
		joeThread.setName("Joe");
		joeThread.start();
		Thread jackThread = new Thread(new Runner(counter));
		jackThread.setName("Jack");
		jackThread.start();
		
		/*
		 * This block counts down the counter until it reaches 0
		 * It cannot be incremented
		 */
		System.out.println("Starting the countdown");
		long countVal = counter.getCount();
		while(countVal > 0) {
			Thread.sleep(1000);
			System.out.println(countVal);
			if(countVal == 1){
				System.out.println("GO!!");
			}
			counter.countDown();
			countVal = counter.getCount();
		}
	}
	
}

class Runner implements Runnable {
	
	private CountDownLatch timer;
	
	public Runner(CountDownLatch cdl){
		this.timer = cdl;
	}
	
	@Override
	public void run(){
		/*
		 * Each thread waits on the timer, which is the CountDownLatch
		 * They cannot start running until the counter reaches 0
		 */
		try{
			System.out.println(Thread.currentThread().getName() + " is ready.");
			timer.await();
		}catch(InterruptedException ie){
			System.err.println("Interrupted -- can't start running the race");
		}
		System.out.println(Thread.currentThread().getName() + " started running...");
	}
}