package javaConcurrent.es1;

public class Consumer extends Thread {

	private Buffer b; // Buffer
	private int id; // Consumer ID

	
	/**
	 * Constructor For The Consumer
	 * 
	 * @param b Reading Buffer
	 * @param id Process ID
	 * 
	 */
	public Consumer (Buffer b, int id) {
		
		this.b = b;
		
		this.id = id;
		
	}
	
	
	/**
	 * Extract An Element From The Buffer
	 */
	private synchronized void extract () {
		
		b.extract ();
		
		System.out.println ("Consumer " + this.id + " extracted");
		
	}
	
	
	/**
	 * Consume The Extracted Element
	 */
	private void consume () {
		
		System.out.println ("Consumer " + this.id + " consumed");
		
	}
	
	
	/**
	 * Run Method For Threads
	 */
	@Override
	public void run () {
		
		while (true) {
			
			this.extract();
			
			this.consume();
			
		}
		
	}
	
	

}
