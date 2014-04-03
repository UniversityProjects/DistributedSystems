package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javaRMI.HelloImplementation;
import javaRMI.HelloInterface;

public class HelloServer {
	
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		int rmiPort = 1099; // RMI Port
		
		LocateRegistry.createRegistry(rmiPort); // Add The Server To The Local Registry
		
		HelloInterface hello = new HelloImplementation(); // Hello Service Instantiation
	    
		Naming.rebind("rmi://localhost:" + rmiPort + "/HelloService", hello); // Rebinding
		
		System.out.println ("Server Running :)");
		
	}
	

}
