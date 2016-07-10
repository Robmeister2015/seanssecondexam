package concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Uses generic type to define return type from call method
 */
public class UsingCallableInterface implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		StringBuilder sb = new StringBuilder();
		int count = ThreadLocalRandom.current().nextInt(1, 11);
		
		/*
		 *Appends to StringBuilder and then returs count 
		 */
		for(int i = 1; i <= count; i ++){
			sb.append("Running...").append(i).append("\n");
		}
		System.out.println(sb.toString());
		return count;
	}

}

class CallableTest {
	public static void main(String[] args){
		/*
		 * Instance of the class that implements Callable
		 */
		Callable<Integer> callable = new UsingCallableInterface();
		
		/*
		 * Executor service that has a fixed thread pool of two
		 */
		ExecutorService execSvce = Executors.newFixedThreadPool(2);
		
		/*
		 * The future is used to get the return value from the Callable
		 */
		Future<Integer> future = execSvce.submit(callable);
		try{
			Integer callableResult = future.get();
			System.out.println("Random : " + callableResult);
			execSvce.shutdown();
		}catch(InterruptedException | ExecutionException ex) {
			System.out.println("Failed");
			ex.printStackTrace();
		}
	}
}
