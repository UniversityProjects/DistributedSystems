package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RegClient {

	
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		Scanner kb = new Scanner(System.in); // Scanner Class
		
		RegInterface service =(RegInterface) Naming.lookup("rmi://localhost/RegService"); // Service Instantation
		
		System.out.println("Client Starting\n\n");
		
		System.out.println ("=========================");
		System.out.println ("Event 1");
		
		System.out.print ("First Person: ");
		service.registration(kb.nextLine(), 1);
		
		System.out.print ("Second Person: ");
		service.registration(kb.nextLine(), 1);
		
		System.out.println ("=========================");
		
		System.out.println ("\n");
		
		
		
		
		System.out.println ("=========================");
		System.out.println ("Event 2");
		
		System.out.print ("First Person: ");
		service.registration(kb.nextLine(), 2);
		
		System.out.print ("Second Person: ");
		service.registration(kb.nextLine(), 2);
		
		System.out.print ("Third Person: ");
		service.registration(kb.nextLine(), 2);
		
		System.out.println ("=========================");
		
		System.out.println ("\n");
		
		
		
		System.out.println ("=========================");
		System.out.println ("Event 1");
		
		System.out.print ("First Person: ");
		service.registration(kb.nextLine(), 1);
		
		System.out.print ("Second Person: ");
		service.registration(kb.nextLine(), 1);
		
		System.out.println ("=========================");
		
		System.out.println ("\n");
		
		
		
		System.out.println ("=========================");
		System.out.println ("Event 2 Partecipant List");
		
		service.eventPrint(2).print();
		
		System.out.println ("=========================");
		
		
		

	}

}
