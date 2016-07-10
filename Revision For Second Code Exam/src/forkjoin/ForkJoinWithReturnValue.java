package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinWithReturnValue extends RecursiveTask<Integer>{
	
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 10000;
	private int[] data;
	private int start, end;
	
	public ForkJoinWithReturnValue(int[] data, int start, int end) {
		this.data = data;
		this.start = start;
		this.end = end;
	}
	
	@Override
	public Integer compute() {
		//If the total number to be processed is below our threshold, process it, else move on
		if(end - start <= THRESHOLD){
			int position = 0;
			for(int i = start; i < end; i ++){
				if(data[i] > data[position]){
				position = i;
				}
			}
			return position;
		}
		else {
			//Split the array in half and create a new RIRA and fork the left
			int halfWay = ((end - start) / 2) + start;
			ForkJoinWithReturnValue left = new ForkJoinWithReturnValue(data, start, halfWay);
			left.fork();
			ForkJoinWithReturnValue right = new ForkJoinWithReturnValue(data, halfWay, end);
			int maxPosRHS = right.compute();
			int maxPosLHS = left.join();
			
			if(data[maxPosLHS] > data[maxPosRHS]){
				return maxPosLHS;
			}else if(data[maxPosRHS] > data[maxPosLHS]){
				return maxPosLHS;
			}else{
				return maxPosLHS < maxPosRHS ? maxPosLHS : maxPosRHS;
			}
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
		//Create new RIRA and tell it to start at 0 and go to the end of the array
		ForkJoinWithReturnValue task = new ForkJoinWithReturnValue(data, 0, data.length);
		//Invoke on fork/join calling the compute method
		Integer maxPosition = fjPool.invoke(task);
		System.out.println("Position: " + maxPosition + "; value: " + data[maxPosition]);
	}
}
