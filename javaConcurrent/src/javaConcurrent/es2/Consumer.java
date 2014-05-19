package javaConcurrent.es2;

public class Consumer extends Thread {

	Buffer b; // Reading Buffer
	private int id; // Process ID
	private int num; // Number Read From b
	private int cNum; // Number Calculated
	
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
		
		this.num = b.extract ();
		
		System.out.println ("Consumer " + id + " extracted " + this.num);
		
	}
	
	
	/**
	 * Consume The Extracted Element
	 */
	private void consume () {
		
		this.cNum =(int) this.num/2;
		
		System.out.println ("Consume " + id + " calculated " + this.cNum);
		
	}
	
	
	/**
	 * Run Method For Threads
	 */
	@Override
	public void run () {
		
		while (true) {
			
			this.extract ();
			
			this.consume ();
			
		}
		
	}
	
	

}
