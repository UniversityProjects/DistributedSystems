package javaConcurrent.es2;

import java.util.Random;

public class Producer extends Thread {

	Buffer b; // Buffer
	private int id; // Process ID
	private int randomNum; // Random Number
	private Random r; // Random Object
	
	
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
		
		this.r = new Random ();
		
	}
	
	
	/**
	 * Produce A Random Int
	 * 
	 */
	private void produce () {
		
		this.randomNum = this.r.nextInt ();
		
		System.out.println ("Producer " + this.id + " produced " + this.randomNum);
		
	}
	
	
	/**
	 * Deposits The Random Number In The Buffer
	 */
	private synchronized void deposit () {
		
		b.deposit (this.randomNum);
		
		System.out.println ("Producer " + this.id + " deposited " + this.randomNum);
		
	}
	
	
	/**
	 * Run Method For Threads
	 */
	@Override
	public void run () {
		
		while (true) {
			
			this.produce ();
			
			this.deposit ();
			
		}
		
	}

}
