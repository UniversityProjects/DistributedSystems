
package javaSocket.es4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Socket4Client {
		
	 
	private Socket clientSoc; // Client Socket
		
	@SuppressWarnings("unused")
	private int port; // Server Port
		
	private String message; // Message For The Server
		
	@SuppressWarnings("unused")
	private String serverIP; // Server IP	
		
		
		
	// Constructor That Creates The Client Socket
	public Socket4Client (int port, String message, String serverIP) throws UnknownHostException, IOException {
			
		
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
				
		request.println (this.message);	// Send Message To Server
			
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
	@SuppressWarnings("unused")
	public static void main (String[] args) throws UnknownHostException, IOException {
		
		int port = 8888; // Communication Port
		
		String message = ""; // Message
		
		String serverIP = "localhost"; // Server Address
		
		double first; // First Number
		
		double second; // Second Number
		
		int input; // Temp Input Var
		
		Scanner kb = new Scanner(System.in); // Scanner Class	
		
		System.out.println ("Input the first number: ");
		
		first = kb.nextDouble(); // First Number
		
		message += first; // Adding The First NUmber To The Message
		
		System.out.println ();
		
		
		do {
			
			System.out.println ("Input one for adding, two for multiplying: ");
			
			input = kb.nextInt(); // Operator Input
			
			if (input != 1 && input != 2) {
				
				System.out.println ("Wrong Input !!!\n");
				
			}
			
		} while (input != 1 && input != 2);
		
		System.out.println ();
		
		if (input == 1) { // Addition
			
			message += " " + "add" + " "; // Adding Opeator To The Message
			
		} else { // Multiplication
			
			message += " " + "molt" + " "; // Adding Opeator To The Message
			
		}
			
		System.out.println ("Input the second number: ");
		
		second = kb.nextDouble(); // Second Number
		
		System.out.println ();
		
		message += second; // Adding The Second Number To The Message
		
		// Client Object Instantiation
		Socket4Client cl = new Socket4Client (port, message, serverIP);
		
		// Scanner Class Closing
		kb.close();

					
	}
	

}
