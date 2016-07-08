package threading;

public class UsingSleepAndJoin extends Thread{

	String[] timeStr = { "Zero", "One", "Two", "Three", "Four", "Five",
		"Six", "Seven", "Eight", "Nine"	};
	
	@Override
	public void run(){
		for(int i = 9; i >= 0; i --){
			try {
				System.out.println(timeStr[i]);
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
	
	/*
	 * Because the main thread continues executing, the "Boom!!" goes off
	 * before the timer finishes
	 * In order to prevent this, we can use Join()
	 */
	public static void main(String[] args){
		UsingSleepAndJoin timer = new UsingSleepAndJoin();
		System.out.println("Starting 10 second count down...");
		timer.start();
		try{
			//This causes main to 'join' timer, meaning it waits for timers execution to complete
			timer.join();
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("Boom!!");
	}
}
