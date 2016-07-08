package threading;

/*
 * Can also implement Runnable, which leaves you free to extend another class
 */
public class TheBasicsOfThreading extends Thread{

	/*
	 *Run must be invoked by calling .start() on a thread.
	 *If it is called as run() it is executed as a normal method
	 */
	@Override
	public void run(){
		System.out.println("In run() method; thread name is: " + getName());
	}
	
	public static void main(String[] args){
		Thread myThread = new TheBasicsOfThreading();
		myThread.start();
		/*
		 * Main is a thread in its own right, whereas each thread also has its own name
		 */
		System.out.println("In main method; thread name is: " +
				Thread.currentThread().getName());
	}
}
