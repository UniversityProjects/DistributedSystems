package javaConcurrent.es1;

public class Main {

	public static void main (String arg[]) {
	
		Buffer b1 = new Buffer (); // Buffer 1
		Buffer b2 = new Buffer (); // Buffer 2
		Buffer b3 = new Buffer (); // Buffer 3
		
		Producer p1 = new Producer (b1, 1); // Producer 1 Instantiation
		Producer p2 = new Producer (b2, 2); // Producer 2 Instantiation
		Producer p3 = new Producer (b3, 3); // Producer 3 Instantiation
	
		Consumer c1 = new Consumer (b1, 1); // Consumer 1 Instantiation
		Consumer c2 = new Consumer (b2, 1); // Consumer 2 Instantiation
		Consumer c3 = new Consumer (b3, 1); // Consumer 3 Instantiation
		
		
		p1.start (); // Producer 1 Start
		p2.start (); // Producer 2 Start
		p3.start (); // Producer 3 Start
		
		c1.start (); // Consumer 1 Start
		c2.start (); // Consumer 2 Start
		c3.start (); // Consumer 3 Start
	
		
	}
	
}
