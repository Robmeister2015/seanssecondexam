package threading;

public class UsingAFlagWithAThread {
	/*
	 * This program executes the print in the run method in a loop until
	 * the thread reaches the kill method and this changes the boolean flag
	 * to tell it to stop
	 */
	public static void main(String[] args){
		SampleRunnable r1 = new SampleRunnable();
		Thread t1 = new Thread(r1);
		t1.start();
		try{
			Thread.sleep(10);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		r1.kill();
		System.out.println("Stopped the other thread...");
	}
}

class SampleRunnable implements Runnable{
	/*
	 * If timeToQuit was not declared volatile then the thread would 
	 * read it only once and never recheck it resulting in an infinite loop
	 */
	private volatile boolean timeToQuit = false;
	
	@Override
	public void run(){
		while(!timeToQuit){
			System.out.println("Doing something...");
		}
		System.out.println("Thread finished");
	}
	public void kill(){
		timeToQuit = true;
	}
}
