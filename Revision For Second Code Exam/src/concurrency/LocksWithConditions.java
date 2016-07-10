package concurrency;

import java.util.concurrent.locks.*;

public class LocksWithConditions {

	private static Lock station = new ReentrantLock();
	private static Condition joeArrival = station.newCondition();
	
	public static void main(String[] args){
		/*
		 * The first thread is a WaitForJoe, so when it runs it grabs the lock and awaits()
		 * The other threads are trains, so in their case they go into their run method, grab their lock, announce their arrival, check
		 * if their name matches the name of Joes train, and if not they release their lock
		 */
		Thread waitJoe = new Thread(new LocksWithConditions().new WaitForJoe());
		waitJoe.start();
		
		Thread parisToMunich = new Thread(new LocksWithConditions().new Train());
		parisToMunich.setName("IC1234 - Paris to Munich");
		parisToMunich.start();
		
		Thread parisToMadrid = new Thread(new LocksWithConditions().new Train());
		parisToMadrid.setName("IC2211 - Paris to Madrid");
		parisToMadrid.start();
		
		Thread madridToParis = new Thread(new LocksWithConditions().new Train());
		madridToParis.setName("IC1122 - Paris to Madrid");
		madridToParis.start();
		
		Thread munichToParis = new Thread(new LocksWithConditions().new Train());
		munichToParis.setName("IC4321 - Paris to Madrid");
		munichToParis.start();
	}

class Train implements Runnable {
	
	@Override
	public void run(){
		/*
		 * Trains lock on station
		 */
		station.lock();
		try{
		System.out.println(Thread.currentThread().getName() + " I've arrived in station ");
		if(Thread.currentThread().getName().startsWith("IC1122")){
			joeArrival.signalAll();
		}
		}finally{
			station.unlock();
		}
	}
	
}

class WaitForJoe implements Runnable {
	
	@Override
	public void run(){
		/*
		 * WaitForJoe locks on station, then awaits a signal
		 * If one of the trains enters it's if condition then it signals all those threads waiting on the joeArrival condtion, in this case just
		 * the WaitForJoe thread
		 */
		System.out.println("Waiting in the station for IC1122 in which Joe is coming");
		station.lock();
		try{
			joeArrival.await();
			System.out.println("Pick-up Joe and go home");
		}catch(InterruptedException ie) {
			ie.printStackTrace();
		}finally{
			station.unlock();
		}
	}
	
}
}