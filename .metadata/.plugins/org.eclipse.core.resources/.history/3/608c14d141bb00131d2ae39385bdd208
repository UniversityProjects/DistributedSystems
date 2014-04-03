
package javaSocket.es2;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Socket2Client {

	
	private Socket clientSoc; // Client Socket
	
	@SuppressWarnings("unused")
	private int port; // Server Port
	
	private String message; // Message For The Server
	
	@SuppressWarnings("unused")
	private String serverIP; // Server IP	 
	
	
	
	// Constructor That Creates The Client Socket
	public Socket2Client (int port, String message, String serverIP) throws UnknownHostException, IOException {
		
		
		this.port = port;
		
		this.message = message;
		
		this.serverIP = serverIP;
		
		
		// Initializing The Client Socket
		this.clientSoc = new Socket(serverIP, port);
		
		
		// Start Communication With Server
		this.writeToServer();
		

	}

	
	
	// Send Message To Server
	private void writeToServer() throws IOException {
		
		PrintWriter request = new PrintWriter(clientSoc.getOutputStream(), true); // Create request
			
		request.println (this.message); // Send Message To Server	
		
		this.readFromServer(); // Read Message From Server
			
		request.close(); // Closing Request
			
		this.socketClose(); // Closing Client Socket
			
	}

	
	
	// Read From Server
	private void readFromServer() throws IOException {
		
		InputStreamReader inputRead = new InputStreamReader(this.clientSoc.getInputStream()); // Create inputRead
		
		BufferedReader request = new BufferedReader(inputRead); // Create request
				
		String line; // Buffer
			
		while ((line = request.readLine()) != null) { // Read Until Line Is Null
					
			System.out.println(this.message + " = " + line);
				
			break;
					
		}
				
		request.close(); // Closing Request
		
	}
	
	

	// Close the socket
	private void socketClose() throws IOException {

		this.clientSoc.close();
					
	}

	
	
	// Main
	public static void main (String[] args) throws UnknownHostException, IOException {
	
		int port = 8888; // Communication Port
	
		String message = "Hello"; // Message To Forward
	
		String serverIP = "localhost"; // Server Address
		
		// Client Object Instantiation
		@SuppressWarnings("unused")
		Socket2Client cl = new Socket2Client (port, message, serverIP);

	}	
		
	
}
