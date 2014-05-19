package javaConcurrent.es1;

public class Buffer {
	
	
	boolean full = false; // Flag Used To Check If The Buffer Is Full
	
	
	/**
	 * Deposits One Element In The Buffer
	 */
	public synchronized void deposit () {
		
		while (full) {
			
			try {
				
				wait ();
				
			} catch (InterruptedException e) {
			
				e.printStackTrace ();
				
			}
			
		}
		
		full = true;
		
		notifyAll ();
		
	}

	
	/**
	 * Extracts One Element From The Buffer
	 */
	public synchronized void extract () {
		
		while (!full) {
			
			try {
				
				wait ();
				
			} catch (InterruptedException e) {
			
				e.printStackTrace ();
				
			}
			
		}
		
		full = false;
		
		notifyAll ();
		
	}


}
