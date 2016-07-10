package concurrency;

import java.util.concurrent.Semaphore;

public class Sempahore {

	/*
	 * Use acquire and release to access and return permit
	 */
	public static void main(String[] args){
	
		/*
		 * Set number of permits in Semaphore
		 * This means that two threads can enter the locked region at once
		 */
		Semaphore machines = new Semaphore(2);
		
		Thread minnieThread = new Thread(new Person(machines));
		minnieThread.setName("Minnie");
		minnieThread.start();
		Thread donaldThread = new Thread(new Person(machines));
		donaldThread.setName("Donald");
		donaldThread.start();
		Thread tomThread = new Thread(new Person(machines));
		tomThread.setName("Tom");
		tomThread.start();
		Thread jerryThread = new Thread(new Person(machines));
		jerryThread.setName("Jerry");
		jerryThread.start();
		Thread casperThread = new Thread(new Person(machines));
		casperThread.setName("Casper");
		casperThread.start();
		
	}
	
}

class Person implements Runnable {
	
	private Semaphore machines;
	
	public Person(Semaphore machines){
		this.machines = machines;
	}
	
	@Override
	public void run(){
		try {
			/*
			 * Two threads can enter this region, as the Semaphore machines has two permits
			 */
			System.out.println(Thread.currentThread().getName() + " trying to get in... ");
			machines.acquire();
			System.out.println(Thread.currentThread().getName() + " taking out money... ");
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " finished... ");
			machines.release();
			
		}catch(InterruptedException ie){
			System.err.println(ie);
		}
	}
	
}
