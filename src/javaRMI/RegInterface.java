package javaRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RegInterface extends Remote {
	
	// Registration To The Event
	public void registration (String surname, int eventCode);
	
	// Print The Partecipants' List
	public Event eventPrint (int eventCode);

}
