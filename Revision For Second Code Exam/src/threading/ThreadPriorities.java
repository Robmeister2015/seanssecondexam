package threading;

public class ThreadPriorities {

	/*
	 * Threads get a default priority of 5
	 * They get the priority of the thread that created them
	 */
	public static void main(String[] args){
		Thread t = new Thread();
		System.out.println(t);
		
		Thread t2 = new Thread();
		System.out.println(t2);
		t2.setName("A Simple Thread");
		t2.setPriority(Thread.MIN_PRIORITY);
		System.out.println(t2);
	}
}
