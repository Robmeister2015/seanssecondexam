package concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerExample {

	public static void main(String[] args){
		
		/*
		 * Exchangers wait until both threads have invoked exchange before exchanging the messages
		 * It is non-deterministic, so the messages can be displayed out of order
		 */
		Exchanger<String> msgs = new Exchanger<String>();
		
		new Thread(new CoffeeShopThread(msgs)).start();
		new Thread(new DukeThread(msgs)).start();
		
	}
}

class DukeThread implements Runnable {
	
	private Exchanger<String> msgs;
	
	public DukeThread(Exchanger<String> args){
		msgs = args;
	}
	
	@Override
	public void run(){
		
		String reply = null;
		
		try {
			reply = msgs.exchange("Duke: Could I have a cup of coffee please?");
			System.out.println(reply);
			
			reply = msgs.exchange("Duke: latte please, no sugar.");
			System.out.println(reply);
			
			reply = msgs.exchange("Duke: Thanks.");
			System.out.println(reply);
			
		}catch(InterruptedException ie) {
			System.err.println("Got interrupted during my silly talk");
		}
		
	}
}

class CoffeeShopThread implements Runnable {
	
	private Exchanger<String> msgs;
	private String greeting = "Hi";
	
	public CoffeeShopThread(Exchanger<String> args){
		msgs = args;
	}
	
	@Override
	public void run(){
		
		String reply = null;
		
		try {
			reply = msgs.exchange("CS: Of course, what would you like?");
			System.out.println(reply);
			
			reply = msgs.exchange("CS: Here you go...");
			System.out.println(reply);
			
			reply = msgs.exchange("You are welcome.");
			System.out.println(reply);
			
		}catch(InterruptedException ie) {
			System.err.println("Got interrupted during my silly talk");
		}
		
	}
}
