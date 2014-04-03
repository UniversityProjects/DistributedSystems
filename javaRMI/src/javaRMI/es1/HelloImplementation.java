package javaRMI.es1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javaRMI.es1.HelloInterface;

public class HelloImplementation extends UnicastRemoteObject implements HelloInterface {


	private static final long serialVersionUID = 1L;

	// Constructor
	public HelloImplementation() throws RemoteException {
		
		super();
	
	}
	
	
	// Greet Implementation
	@Override
	public String greet(String name) throws RemoteException {
		
		return "Hello " + name;
	
	}
	

}
