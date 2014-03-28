package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import javaRMI.CalcImplementation;
import javaRMI.CalcInterface;

public class CalcServer {
	
	
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		
		int rmiPort = 1099; // RMI Port
		
		LocateRegistry.createRegistry(rmiPort); // Add The Server To The Local Registry
		
		CalcInterface calc = new CalcImplementation(); // Calculator Service Instantiation
	    
		Naming.rebind("rmi://localhost:" + rmiPort + "/CalcService", calc); // Rebinding
		
		System.out.println ("Server Running :)");
		
	}
	

}
