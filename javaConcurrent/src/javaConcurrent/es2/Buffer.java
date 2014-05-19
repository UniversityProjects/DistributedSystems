package javaConcurrent.es2;

public class Buffer {
	
	
	boolean full = false; // Flag Used To Check If The Buffer Is Full
	
	private int buffer; // Variable Used As A Buffer
	
	
	/**
	 * Deposits One Element In The Buffer
	 */
	public synchronized void deposit (int number) {
		
		while (full) {
			
			try {
				
				wait ();
				
			} catch (InterruptedException e) {
			
				e.printStackTrace ();
				
			}
			
		}
		
		this.buffer = number;
		
		full = true;
		
		notifyAll ();
		
	}

	
	/**
	 * Extracts One Element From The Buffer
	 */
	public synchronized int extract () {
		
		while (!full) {
			
			try {
				
				wait ();
				
			} catch (InterruptedException e) {
			
				e.printStackTrace ();
				
			}
			
		}
		
		full = false;
		
		notifyAll ();
		
		return this.buffer;
		
	}


}
