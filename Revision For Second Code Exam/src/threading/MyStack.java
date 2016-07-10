package threading;

public class MyStack {

	private int top = 0;
	private int size = 100;
	private char[] buffer = new char[size];
	
	/*
	 * If a thread is using this method, then any other synchronised
	 * method is off-limits for any other thread
	 */
	public synchronized void push(char c){
		//This avoids overflow
		while(top == size){
			try {	
				wait();
			} catch (InterruptedException e) {
				System.out.println("Waiting interrupted!");
			}
		}
		buffer[top] = c;
		top ++;
		notifyAll();
	}
	
	/*
	 * Synchronised with push
	 */
	public synchronized char pop(){
		//This avoids underflow
		while(top == 0){
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		top --;
		return buffer[top];
	}
	
	public void foo(){
		
	}
	
}

class Producer implements Runnable {
	private MyStack theStack;
	private int num;
	private static int counter = 1;
	
	public Producer(MyStack stack){
		theStack = stack;
		num = counter ++;
	}
	
	public void run(){
		char c;
		for(int i = 1; i < 20; i ++){
			c = (char)(Math.random() * 26 + 'A');
			theStack.push(c);
			System.out.println("Producer" + num + ": " + c);
			try{
				Thread.sleep((int)(Math.random() * 300));
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private MyStack theStack;
	private int num;
	private static int counter = 1;
	
	public Consumer(MyStack stack){
		theStack = stack;
		num = counter ++;
	}
	
	public void run(){
		char c;
		for(int i = 1; i < 20; i ++){
			c = theStack.pop();
			System.out.println("Consumer" + num + ": " + c);
			try{
				Thread.sleep((int)(Math.random() * 300));
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
}

class Main {
	public static void main(String[] args){
		MyStack stack = new MyStack();
		
		Producer producer = new Producer(stack);
		Thread producerThread = new Thread(producer);
		producerThread.start();
		
		Consumer consumer = new Consumer(stack);
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();
	}
}
