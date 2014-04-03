package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Calclient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Scanner kb = new Scanner(System.in); // Scanner Class
		
		double first; // First Number
		
		double second; // Second Number
		
		String message = new String(); // Message To Pass To The Server
		
		String input = new String(); // Temp Input Var
		
		String result = new String(); // Calculation Result
		
		CalcInterface service =(CalcInterface) Naming.lookup("rmi://localhost/CalcService"); // Service Instantation
		
		System.out.println ("Input the first number: ");
		
		first = kb.nextDouble(); // First Number
		
		System.out.println ();
		
		System.out.println ("Input the second number: ");
		
		second = kb.nextDouble(); // Second Number
		
		System.out.println ();
		
		
		do { // Operation Input
			
			System.out.println ("Input the operation: ");
			System.out.println ("1) + for addition");
			System.out.println ("2) - for aubtraction");
			System.out.println ("3) * for multiplication");
			System.out.println ("4) / for division");
			
			System.out.print ("\nChoice: ");
			
			input = kb.next();
			
			System.out.println("\n");
			
			if (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/")) {
				
				System.out.println ("Wrong Input " + input + "!!!\n");
				
			}
			
		} while (!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/"));
		
		System.out.println ();
		
		message += first; // Adding The First NUmber To The Message
		
		message += " " + input + " "; // Adding Operator To The Message		
			
		message += second; // Adding The Second Number To The Message
		
		result = service.calculator (message); // Ask The Result
		
		System.out.println (message + " = " + result); // Print Result
		
		kb.close(); // Scanner Close
	
	}

}
