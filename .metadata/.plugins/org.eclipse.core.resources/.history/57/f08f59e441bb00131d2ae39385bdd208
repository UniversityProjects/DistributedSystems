
package javaSocket.es3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket3Server {

	
	private ServerSocket serverSock; // Server Socket
	
	private Socket clientCommunication; // Socket For Communication
	
	private int port; // Server Port
	
	
	
	// Server Constructor
	public Socket3Server (int port) throws IOException {
		
		// Port
		this.port = port;		
	
		
		// While Loop For Multiple Clients
		while (true) {
			
			// Server Socket Initialization
			this.socketStarter();
		
			// Read From Single Client
			this.readFromClient();
			
			
		}
		
		
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
			
		BufferedReader request = new BufferedReader (inputRead); // Create request
			
		String line; // Buffer	 	
			
		while ((line = request.readLine()) != null) { // Read Until Line Is Null
				
			System.out.println("Client says: " + line);
			
			this.writeToClient(line); // Write To Client
			
			break;
				
		}
						
		request.close(); // Closing Request
			
		this.clientCommunication.close(); // Closing Client Socket Communication
			 
		this.serverSock.close(); // Closing Server Socket
		
	}

	
	
	// Write To The Client
	public void writeToClient(String line) throws IOException {		
		
		PrintWriter req = new PrintWriter(this.clientCommunication.getOutputStream(), true); // Create req
			
		req.println (line); // Send Line To Client
			
		req.close(); // Closing Request
		
	}
	
	
	
	// Main
	public static void main(String[] args) throws IOException {
		
		int port = 8888; // Communication Port
		
		// Server Object Instantiation
		@SuppressWarnings("unused")
		Socket3Server sr = new Socket3Server (port);
	
	}
	
	
}
