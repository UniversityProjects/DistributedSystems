package javaRMI.es3;

import java.rmi.Remote;


public interface RegInterface extends Remote {
	
	// Registration To The Event
	public void registration (String surname, int eventCode);
	
	// Print The Partecipants' List
	public Event eventPrint (int eventCode);

}
