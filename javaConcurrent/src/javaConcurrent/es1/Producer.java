package javaConcurrent.es1;

public class Producer extends Thread {

	private Buffer b; // Buffer
	private int id; // Producer ID
	
	
	/**
	 * Constructor For The Producer
	 * 
	 * @param b Writing Buffer
	 * @param id Process ID
	 * 
	 */
	public Producer (Buffer b, int id) {
		
		this.b = b;
		this.id = id;
		
	}
	
	
	/**
	 * Method Produce
	 */
	private void produce () {
		
		System.out.println ("Producer " + this.id + " produced");
		
	}
	
	
	/**
	 * Deposits In The Buffer
	 */
	private synchronized void deposit () {
		
		b.deposit ();
		
		System.out.println ("Producer " + this.id + " deposited");
		
	}
	
	
	/**
	 * Run Method For Threads
	 */
	@Override
	public void run () {
		
		while (true) {
			
			this.produce();
			
			this.deposit();
			
		}
		
	}

}
