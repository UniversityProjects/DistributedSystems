package javaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloInterface extends Remote {
	
	// Greeting Method
	public String greet (String name) throws RemoteException;

}
