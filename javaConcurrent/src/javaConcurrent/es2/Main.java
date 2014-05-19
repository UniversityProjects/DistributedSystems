package javaConcurrent.es2;

import javaConcurrent.es2.Buffer;
import javaConcurrent.es2.Consumer;
import javaConcurrent.es2.Producer;
import javaConcurrent.es2.Quadratic;

public class Main {

	public static void main (String arg[]) {
	

		Buffer b1 = new Buffer (); // Buffer Between Producer And Quadratic
		Buffer b2 = new Buffer (); // Buffer Between Quadratic And Consumer
		
		
		Producer p1 = new Producer (b1, 1); // Producer Instantiation
		Quadratic q1 = new Quadratic (b1, b2, 2); // Quadratic Instantiation
		Consumer c1 = new Consumer (b2, 3); // Consumer Instantiation
				
		
		p1.start (); // Producer Start
		q1.start (); // Quadratic Start		
		c1.start (); // Consumer 1 Start
	
		
	}
	
}
