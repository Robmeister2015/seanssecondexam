package threading;

/*
 * Reentrant synchronization allows a thread to enter another 
 * critical area by acquiring a lock that it already owns
 * This avoids the possibility of a thread blocking itself
 */
class Worker implements Runnable {

	@Override
	public void run(){
		doWork();
	}
	
	public synchronized void doWork(){
		System.out.println("doWork()");
		moreWork();
	}
	
	public synchronized void moreWork(){
		System.out.println("moreWork()");
	}
}

public class ReentrantSynchronization {
	public static void main(String[] args){
		Runnable job = new Worker();
		Thread worker = new Thread(job);
		worker.start();
	}
}