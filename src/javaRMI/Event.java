package javaRMI;

import java.io.Serializable;



public class Event implements Serializable{
	
	private String[] partecipantsList;
	
	public Event () {
		
		this.partecipantsList = new String[0];
		
	}
	
	public Event (String partecipantList[]) {
		
		this.partecipantsList = new String[partecipantList.length];
		
		for (int i = 0; i < partecipantList.length; i++) {
			
			this.partecipantsList[i] = partecipantList[i];
			
		}
		
	}
	
	// Add The Surname To The List. Check For Doubles
	public void partecipate(String surname) {
		
		String[] partecipantList = this.partecipantsList.clone();
		
		this.partecipantsList = new String[partecipantList.length+1];
		
		for (int i = 0; i < partecipantList.length; i++) {
			
			this.partecipantsList[i] = partecipantList[i];
			
		}
		
		this.partecipantsList[partecipantList.length] = surname;

		
	}
	
	
	// Prints THe Partecipants List
	public void print () {
		
		this.partecipantsList.toString();
		
	}

}
