package threading;

class Cntr {
	public static long count = 0;
}

class UseCounterThread implements Runnable {

	/*
	 * Because ++ is not an atomic operation at the machine level, it is possible for
	 * threads to overlap in the increment operation
	 * Synchronized added below stops threads from executing on the variable
	 * at the same time
	 */
	public void increment(){
		synchronized(this){
		Cntr.count ++;
		System.out.println(Cntr.count + " ");
	}
	}
	
	@Override
	public void run() {
		increment();
		increment();
		increment();
	}
	
}

public class RaceConditions {
public static void main(String[] args){
	UseCounterThread c = new UseCounterThread();
	Thread t1 = new Thread(c);
	Thread t2 = new Thread(c);
	Thread t3 = new Thread(c);
	t1.start();
	t2.start();
	t3.start();
	
}
}
