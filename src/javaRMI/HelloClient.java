package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class HelloClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Scanner kb = new Scanner(System.in); // Scanner Class
		
		String name; // Client Name
		
		String greetings; // Server Greeting
		
		HelloInterface service =(HelloInterface) Naming.lookup("rmi://localhost/HelloService"); // Service Instantation
		
		System.out.println ("Input your name: "); // Client Name Request
		
		name = kb.nextLine(); // Second Number // Client Name Saving
		
		greetings = service.greet(name); // Ask Greetings
		
		System.out.println (greetings); // Print Greetings
		
		kb.close(); // Scanner Close
	
	}

}