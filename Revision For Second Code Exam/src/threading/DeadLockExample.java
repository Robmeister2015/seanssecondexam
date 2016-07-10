package threading;

public class DeadLockExample {
	public static void main(String[] args) throws InterruptedException {
		
		Counter c = new Counter();
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
		System.out.println("Waiting for threads to complete execution");
		t1.join();
		t2.join();
		System.out.println("Done.");
		
	}
}

class Balls {

	public static long balls = 0;
	
}

class Runs {
	
	public static long runs = 0;
	
}

class Counter implements Runnable {
	
	public void incrementBallAfterRun() {
		synchronized(Runs.class) {
			synchronized(Balls.class) {
				Runs.runs ++;
				Balls.balls ++;
			}
		}
	}
	
	public void incrementRunAfterBall(){
		synchronized(Balls.class){
			synchronized(Runs.class) {
				Balls.balls ++;
				Runs.runs ++;
			}
		}
	}
	
	public void run() {
		incrementBallAfterRun();
		incrementRunAfterBall();
	}
	
}
