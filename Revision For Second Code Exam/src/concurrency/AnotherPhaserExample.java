package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class AnotherPhaserExample {

	public static void main(String[] args){
		
		List<Runnable> tasks = new ArrayList<>();
		tasks.add(new SomeTask());
		tasks.add(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + ".run()");
			}
		});
		new AnotherPhaserExample().runTasks(tasks);
		
	}
	
	private void runTasks(List<Runnable> tasks) {
		final Phaser phaser = new Phaser(1);
		
		for(final Runnable task : tasks){
			phaser.register();
			new Thread() {
				@Override
				public void run(){
					System.out.println(Thread.currentThread().getName() + " waiting...");
					phaser.arriveAndAwaitAdvance();
					System.out.println(Thread.currentThread().getName() + " running...");
					task.run();
				}
			}.start();
		}
		try{
			Thread.sleep(5000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " deregistering...");
		phaser.arriveAndDeregister();
	}
	
}

class SomeTask implements Runnable {
	
	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName() + ".run()");
	}
	
}