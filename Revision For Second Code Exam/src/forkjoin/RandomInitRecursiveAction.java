package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomInitRecursiveAction extends RecursiveAction {

	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start, end;
	
	public RandomInitRecursiveAction(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void compute() {
		//If the total number to be processed is below our threshold, process it, else move on
		if(end - start <= THRESHOLD){
			for(int i = start; i < end; i ++){
				data[i] = ThreadLocalRandom.current().nextInt();
			}
		}
		else {
			//Split the array in half and create a new RIRA and fork the left
			int halfWay = ((end - start) / 2) + start;
			RandomInitRecursiveAction left = new RandomInitRecursiveAction(data, start, halfWay);
			left.fork();
			RandomInitRecursiveAction right = new RandomInitRecursiveAction(data, halfWay, end);
			right.compute();
			left.join();
		}
	}
	
	public static void main(String[] args){
		//Create array of 10 million
		int[] data = new int[10_000_000];
		//Create fork/join pool
		ForkJoinPool fjPool = new ForkJoinPool();
		//Create new RIRA and tell it to start at 0 and go to the end of the array
		RandomInitRecursiveAction action = new RandomInitRecursiveAction(data, 0, data.length);
		//Invoke on fork/join calling the compute method
		fjPool.invoke(action);
	}
	
}
