package threading;

public class WorkingWithRunnable implements Runnable{

	/*
	 *First of all, we have to override run, the only method in Runnable
	 */
	@Override
	public void run() {
		System.out.println("In run() method; thread name is: " + Thread.currentThread().	getName());
	}
	
	public static void main(String[] args){
		/*
		 * In order to start a thread from a Runnable, we must create a thread
		 * and pass it the runnable
		 */
		
		Runnable r = new WorkingWithRunnable();
		Thread myThread = new Thread(r);
		
		myThread.start();
		System.out.println("In main method; thread name is: " +
				Thread.currentThread().getName());
	}

}
