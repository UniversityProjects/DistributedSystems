
package javaSocket.es1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Socket1Server {
	
	private ServerSocket serverSock; // Server Socket
	
	private Socket clientCommunication; // Socket For Communication
	
	int port; // Server Port
	
	
	// Server Constructor
	public Socket1Server (int port) throws IOException {
		
		// Port
		this.port = port;
		
		
		// Server Socket Initialization
		this.socketStarter();
		
		// Read From Client
		this.readFromClient();
		
		
	}
	
	
	// Socket Initializer
	public void socketStarter () throws IOException {
		
		// Server Socket Initialization
		this.serverSock = new ServerSocket (this.port);
				
				
		// Client-Server Communication Socket Initialization
		this.clientCommunication = this.serverSock.accept();
		
	}

	
	// Read From Client
	public void readFromClient() throws IOException {
		
		InputStreamReader inputRead = new InputStreamReader(this.clientCommunication.getInputStream()); // Create inputRead
			
		BufferedReader request = new BufferedReader(inputRead); // Create request
			
		String line; // Buffer
			
		while ((line = request.readLine()) != null) { // Read Until Line Is Null
				
			System.out.println("Client says: " + line);
			
		}
			
		request.close(); // Closing Request
			
		this.clientCommunication.close(); // Closing Client Socket Communication
		 
		this.serverSock.close(); // Closing Server Socket
		
		
	}

	
	// Main
	public static void main(String[] args) throws IOException {
		
		int port = 8888; // Communication Port
		
		// Server Object Instantiation
		@SuppressWarnings("unused")
		Socket1Server sr = new Socket1Server (port);
	
	}
	
}
