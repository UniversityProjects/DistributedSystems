package javaRMI.es3;

import java.rmi.RemoteException;
import javaRMI.es3.RegInterface;

public class RegImplementation implements RegInterface {

	
	private Event[] eventList; 


	// Constructor With ArrayList Parameter
	public RegImplementation (Event[] eventList) throws RemoteException {
		
		super();
		
		this.eventList = new Event[eventList.length];
		
		for (int i = 0; i < eventList.length; i++) {
			
			this.eventList[i] = eventList[i];
			
		}
	
	}
	
	
	// Add A Partecipant To The Event
	@Override
	public void registration (String surname, int eventCode) {
		
		this.eventPrint(eventCode).partecipate(surname);		
		
	}
	
	// Return The Specified Event
	@Override
	public Event eventPrint(int eventCode) {
	
		return this.eventList[eventCode - 1];
		
	}

}
