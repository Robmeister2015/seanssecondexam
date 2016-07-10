package threading;

public class CoffeeShopExample {

	/*
	 * Create a waiter and a coffee machine thread and start them both
	 */
	public static void main(String[] args){
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		Waiter waiter = new Waiter();
		coffeeMachine.start();
		waiter.start();
	}
}

class CoffeeMachine extends Thread {
	static String coffeeMade = null;
	static final Object lock = new Object();
	private static int coffeeNumber = 1;
	
	void makeCoffee() {
		/*
		 * All code in this block is synched on CoffeeMachine.lock
		 */
		synchronized(CoffeeMachine.lock) {
			coffeeMade = "Coffee No." + coffeeNumber ++;
			System.out.println("Coffee machine says: Made " + coffeeMade);
			System.out.println("Coffee machine: notifyAll()");
			/*
			 * When we reach the end of the block, notify all threads
			 */
			CoffeeMachine.lock.notifyAll();
		}
	}
	
	@Override
	public void run(){
		while(true){
			/*
			 * Call makeCoffee
			 */
			makeCoffee();
			try {
				System.out.println("Coffee machine: Sleep...");
				Thread.sleep(3000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

class Waiter extends Thread {
	
	/*
	 * The waiter will attempt to get coffee, but the method is synchronised with the upper block
	 */
	public void getCoffee(){
		synchronized(CoffeeMachine.lock) {
			if(CoffeeMachine.coffeeMade == null){
				try {
					System.out.println("Waiter: wait()");
					CoffeeMachine.lock.wait();
				}catch(InterruptedException ie){
					ie.printStackTrace();
				}
			}
			System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
			CoffeeMachine.coffeeMade = null;
		}
	}
	
	@Override
	public void run(){
		while(true){
			getCoffee();
		}
	}
}