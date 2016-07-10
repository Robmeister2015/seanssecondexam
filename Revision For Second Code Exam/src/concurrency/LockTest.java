package concurrency;

import java.util.concurrent.locks.*;

public class LockTest {

	public static void main(String[] args){
		
		Lock machineLock = new ReentrantLock();
		
		Thread minnieThread = new Thread(new Somebody(machineLock));
		minnieThread.setName("Minnie");
		minnieThread.start();
		Thread donaldThread = new Thread(new Somebody(machineLock));
		donaldThread.setName("Donald");
		donaldThread.start();
		Thread tomThread = new Thread(new Somebody(machineLock));
		tomThread.setName("Tom");
		tomThread.start();
		Thread jerryThread = new Thread(new Somebody(machineLock));
		jerryThread.setName("Jerry");
		jerryThread.start();
		Thread casperThread = new Thread(new Somebody(machineLock));
		casperThread.setName("Casper");
		casperThread.start();
	}
	
}

class Somebody implements Runnable {
	
	private Lock machineLock;
	
	public Somebody(Lock machineLock) {
		this.machineLock = machineLock;
	}
	
	/*
	 *In the method below, anything below the lock is inaccessible until the lock is released in the finally block
	 */
	@Override
	public void run() {
		try{
			System.out.println(Thread.currentThread().getName() + " waiting to access an ATM machine");
			machineLock.lock();
			System.out.println(Thread.currentThread().getName() + " is accessing an ATM machine **");
			Thread.sleep(1000);
		}catch(InterruptedException ie){
			System.err.println(ie);
		}finally{
			System.out.println(Thread.currentThread().getName() + " is done using the ATM machine **");
			/*
			 * If you don't release the lock, then the program will lock. It won't shut down, it will just sit
			 */
			machineLock.unlock();
		}
	}
	
}