package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LocksAndTheirUse {

	/*
	 * A reentrant lock is one where a thread can claim the lock multiple times without blocking on itself
	 * You must explicitly unlock in the finally block, as this isn't automatic like it is with threading
	 */
	
	public static void main(String[] args){
		
		Lock lock = new ReentrantLock();
		lock.lock();
		
		try{
			//Do stuff in the critical section
		}finally{
			lock.unlock();
		}
	}
}
