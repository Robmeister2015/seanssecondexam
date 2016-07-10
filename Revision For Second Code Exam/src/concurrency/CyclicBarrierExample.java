package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class MixedDoublesTennis implements Runnable {
	
	@Override
	public void run(){
		System.out.println("All four players ready, game "
				+ "starts \nLove all...");
	}
	
}

public class CyclicBarrierExample {

	public static void main(String[] args){
		
		System.out.println("Reserving tennis court \nAs soon as four players "
				+ "arrive game will start");
		
		/*
		 * Create a new CyclicBarrier that waits for 4 threads and has a MixedDoublesTennis thread, which can't invoke it's run method until
		 * 4 threads have arrived at the waitPoint
		 */
		CyclicBarrier barrier = new CyclicBarrier(4, new MixedDoublesTennis());
		
		Thread mike = new Thread(new Player(barrier));
		mike.setName("Mike");
		mike.start();
		Thread john = new Thread(new Player(barrier));
		john.setName("John");
		john.start();
		Thread anne = new Thread(new Player(barrier));
		anne.setName("Anne");
		anne.start();
		Thread pauline = new Thread(new Player(barrier));
		pauline.setName("Pauline");
		pauline.start();
		
	}
	
}

class Player implements Runnable {
	
	CyclicBarrier waitPoint;
	
	public Player(CyclicBarrier barrier) {
		waitPoint = barrier;
	}
	
	@Override
	public void run(){
		System.out.println("Player " +
				Thread.currentThread().getName() + " is ready ");
		try {
			/*
			 * Until 4 threads have reached this point, tennis game cannot start
			 */
			waitPoint.await();
		}catch(BrokenBarrierException | InterruptedException exception) {
			System.out.println("An exception occured while waiting... " + exception);
		}
	}
	
}