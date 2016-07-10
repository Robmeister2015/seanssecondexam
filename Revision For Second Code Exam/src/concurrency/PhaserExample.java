package concurrency;

import java.util.concurrent.Phaser;

public class PhaserExample {

	public static void main(String[] args) throws InterruptedException {
		
	Phaser deliveryOrder = new Phaser(1);
	
	System.out.println("Starting to process the delivery order ");
	
	new Worker(deliveryOrder, "Cook");
	new Worker(deliveryOrder, "Helper");
	new Worker(deliveryOrder, "Attendant");
	
	final int NUM_ORDERS = 3;
	
	for(int i = 1; i <= NUM_ORDERS; i ++) {
		System.out.println("\t" + Thread.currentThread().getName() + " waiting...");
		deliveryOrder.arriveAndAwaitAdvance();
		System.out.println("Order number: " + i + "ready");
	}
	
	deliveryOrder.arriveAndDeregister();
	System.out.println("All the orders are ready; deliver them...");
	
	}
	
}

class Worker extends Thread {
	Phaser deliveryOrder;
	
	Worker(Phaser order, String name){
		deliveryOrder = order;
		this.setName(name);
		deliveryOrder.register();
		start();
	}
	
	@Override
	public void run(){
		final int STARTER = 1, MAIN_COURSE = 2, DESSERT = 3;
		for(int i = STARTER; i <= DESSERT; i ++){
			String mealComponent = getMealComponent(i);
			if(i == DESSERT) {
				System.out.println("\t" + getName() + " waiting to start: " + mealComponent);
				deliveryOrder.awaitAdvance(deliveryOrder.arriveAndDeregister());
			}else{
				System.out.println("\t" + getName() + " waiting to start: " + mealComponent);
				deliveryOrder.arriveAndAwaitAdvance();
			}
			try{
				System.out.println("\t\t" + getName() + " working on: " + mealComponent);
				Thread.sleep(2000);
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	public String getMealComponent(int component){
		switch(component){
		case 1:
			return "starter";
		case 2:
			return "main course";
		case 3:
			return "dessert";
		default:
			return "";
		}
	}
}