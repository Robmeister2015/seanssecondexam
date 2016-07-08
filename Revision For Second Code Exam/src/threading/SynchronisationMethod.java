package threading;

/*
 * Two of these methods may not execute at the same time. This means that the
 * value will be kept accurate. C cannot be incremented if it is currently being 
 * decremented or returned, etc
 */
public class SynchronisationMethod{

	private int c = 0;
	
	public synchronized void increment(){
		c ++;
	}
	
	public synchronized void decrement(){
		c --;
	}
	
	public synchronized int value(){
		return c;
	}
}

class Locking implements Runnable{
	
	private int x;
	private static int y;
	
	/*
	 * Non-static blocks lock on an object that you specify
	 */
	
	public void incrementA(){
		synchronized(this){
			x ++;
		}
	}
	
	/*
	 * Non-static methods lock on 'this' implicitly
	 */
	public synchronized void incrementB(){
		x ++;
	}
	
	/*
	 * Static blocks lock on a class object
	 */
	public void decrementA(){
		synchronized(Locking.class){
			y --;
		}
	}

	/*
	 * Static methods lock on the class object implicitly
	 */
	public static synchronized void decrementB(){
		y --;
	}
	@Override
	public void run() {
		
	}
	
}
