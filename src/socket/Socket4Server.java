
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Socket4Server {


	private ServerSocket serverSock; // Server Socket
	
	private Socket clientCommunication; // Socket For Communication
	
	private int port; // Server Port
	
	
	
	// Server Constructor
	public Socket4Server (int port) throws IOException {
			
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
				
		String result = this.calculation (line); // Perform The Input Parsing And The Actual Calculation
		
		req.println (result); // Send Result To Client
				
		req.close(); // Closing Request
			
	}
		
		
	// Input Parser And Calculator
	private String calculation(String line) {
		
		int lenght = line.length(); // Line Length
		
		boolean dotFound = false; // Flag To Check For Multiple Dots
		
		double first = 0; // First Number
		
		double second = 0; // Second Number
		
		boolean add = false; // Addition Flag
		
		boolean molt = false; // Multiplication Flag
		
		int pos = 0; // Position Index
		
		Character tmp; // Temp Char To Hold The Current Char To Analyze
		
		double res = 0; // Final Result
		
		String result = ""; // Return Value
		
		// Read First Number
		for (int i = 0; i < lenght; i++) {
			
			tmp = line.charAt(i); // Char At Position i
			
			if ( tmp == '.' || Character.isDigit(tmp) || tmp == ' ') { // Valid chars
				
				if ( tmp == '.' ) { // Dot Found
					
					if (dotFound || i == 0 || i == lenght - 1) { // Only One Dot, Followed Or Preceded By A Digit
						
						return ("# Error: Wrong Input At Pos " + pos + " !!!");
						
					} else {
						
						dotFound = false;
						
					}
					
				}
				
				if ( tmp == ' ' ) { // Space Found, End Of The First Number
					
					if (i == 0) { // Only Digit At First Position
					
						return ("# Error: Wrong Input At Pos " + pos + " !!!");
					
					}
					
					if (line.charAt(i - 1) == '.') { // Space Cannot Be Preceded By A Dot
						
						return ("# Error: Wrong Input At Pos " + pos + " !!!");
						
					}
					
					break;
					
				}
				
				pos = i; // Increment pos
				
			} else {
				
				return ("# Error: Wrong Input At Pos " + pos + " !!!");
				
			}
			
			
		}
		
		first = Double.parseDouble(line.substring(0, pos)); // First Number Done
		
		dotFound = false; // Reset Dot Flag
		
		pos++;
		
		if (line.charAt(pos) == ' ') {
			
			pos++;
			
		} else { // Every Expression Must Be Separed By A Space
			
			return ("# Error: Wrong Input At Pos " + pos + " !!!");
			
		}
		
		if (lenght > pos+3) { // Check Line's End
		
			if (line.substring(pos, pos+3).equals("add")) {
			
				add = true; // Addition Found
			
				pos += 3; // Go To The Next Expression
			
			}
			
		} else {
			
			return ("# Error: Wrong Input At Pos " + pos + " !!!");
			
		}
		
		
		if (!add) { // If Addition Hasn't Been Found
			
			if (lenght > pos+4) { // Check Line's End
		
				if (line.substring(pos, pos+4).equals("molt")) {
			
					molt = true; // Multiplication Found
			
					pos += 4; // Go To The Next Expression
				
				}
				
			} else {
				
				return ("# Error: Wrong Input At Pos " + pos + " !!!");
				
			}
			
		}
		
		if (!add && !molt) { // No Suitable Operator FOund
			
			return ("# Error: Wrong Input At Pos " + pos + " !!!");
			
		}
		
		if (line.charAt(pos) == ' ') { // Next Separator Space
			
			pos++;
			
		} else {
			
			return ("# Error: Wrong Input At Pos " + pos + " !!!");
			
		}
		
		// Read Second Number
		for (int i = pos; i < lenght; i++) {
					
			tmp = line.charAt(i); // Char At Position i
					
			if ( tmp == '.' || Character.isDigit(tmp) || tmp == ' ' ) {
				
				if ( tmp == '.' ) {
					
					if (dotFound || i == pos || i == lenght - 1) {
								
						return ("# Error: Wrong Input At Pos " + i + " !!!");
								
					} else {
								
						dotFound = false;
								
					}
							
				}
						
				if ( tmp == ' ' ) {
							
					if (line.charAt(i - 1) == '.') {
								
						return ("# Error: Wrong Input At Pos " + i + " !!!");
								
					}
							
					break;
							
				}				
						
			} else {
						
				return ("# Error: Wrong Input At Pos " + i + " !!!");
						
			}
					
					
		}
		
		second = Double.parseDouble(line.substring(pos, lenght)); // Second Number Done
		
		if (add) { // Addition
			
			res = first + second;
			
		}	
		
		if (molt) { // Multiplication
			
			res = first*second;
			
		}
		
		result = "" + res; // To String
		
		return result; // Return
		
	}


	// Main
	public static void main(String[] args) throws IOException {
			
		int port = 8888; // Communication Port
			
		// Server Object Instantiation
		@SuppressWarnings("unused")
		Socket4Server sr = new Socket4Server (port);
		
	}
		
			
		

}
