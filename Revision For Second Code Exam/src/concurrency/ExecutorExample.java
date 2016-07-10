package concurrency;

import java.util.concurrent.Executor;

public class ExecutorExample implements Runnable {

	@Override
	public void run(){
		System.out.println("run() ");
	}
	
}

class NewThreadExecutor implements Executor {
	
	@Override
	public void execute(Runnable runnable) {
		new Thread(runnable).start();
	}
	
}

class ExecutorTest {
	public static void main(String[] args){
		new Thread(new ExecutorExample()).start();
		
		Executor executor = new NewThreadExecutor();
		executor.execute(new ExecutorExample());
	}
}