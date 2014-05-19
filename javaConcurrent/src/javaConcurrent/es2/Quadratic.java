package javaConcurrent.es2;

import javaConcurrent.es2.Buffer;

public class Quadratic extends Thread {

	Buffer b1; // Reading Buffer
	Buffer b2; // Writing Buffer
	private int id; // Process ID
	private int num; // Number Read From b1
	private int quadNum; // Number To Be Deposited In b1
	
	
	/** 
	 * Quadratic Constructor
	 * 
	 * @param b1 Reading Buffer
	 * @param b2 Writing Buffer
	 * @param id Process ID
	 * 
	 */
	public Quadratic (Buffer b1, Buffer b2, int id) {
		
		this.b1 = b1;
		
		this.b2 = b2;
		
		this.id = id;
		
	}
	
	
	/** 
	 * Method To Extract The Number From Buffer b1
	 */
	private synchronized void extract () {
		
		this.num = b1.extract ();
		
		System.out.println ("Quadratic " + id + " extracted " + this.num);
		
	}

	
	/**
	 * Method For The Calculation
	 */
	private void calculate () {
		
		this.quadNum = this.num*this.num;
		
		System.out.println ("Quadratic " + id + " calculated " + this.quadNum);
		
	}
	
	
	/**
	 * Method To Deposit The Number To Buffer b2
	 */
	private synchronized void deposit () {
		
		b2.deposit (this.quadNum);
		
		System.out.println ("Quadratic " + id + " deposited " + this.quadNum);
		
	}
	
	
	/**
	 * Run Method
	 */
	@Override
	public void run () {
		
		while (true) {
			
			this.extract ();
			
			this.calculate ();
			
			this.deposit ();
		
		}
		
	}


}
