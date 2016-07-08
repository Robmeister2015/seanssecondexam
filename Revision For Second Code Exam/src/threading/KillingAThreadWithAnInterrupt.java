package threading;

public class KillingAThreadWithAnInterrupt {

	/*
	 * Rare use case of interrupt, using keyboard input to throw InterruptedException
	 */
	public static void main(String[] args) throws Exception {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run(){
				try{
					while(!Thread.currentThread().isInterrupted()){
						Thread.sleep(3000);
						System.out.println("Hello World!");
					}
				}catch(InterruptedException e){
					
				}
			}
			
		});
		thread.start();
		System.out.println("Press enter to quit");
		System.in.read();
		thread.interrupt();
	}
	
}
