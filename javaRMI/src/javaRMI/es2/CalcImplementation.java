package javaRMI.es2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javaRMI.es2.CalcInterface;

public class CalcImplementation extends UnicastRemoteObject implements CalcInterface {


	private static final long serialVersionUID = 1L;

	// Constructor
	public CalcImplementation() throws RemoteException {
		
		super();
	
	}
	
	
	// Input Parser And Calculator
	@Override
	public String calculator (String line) {
			
		int lenght = line.length(); // Line Length
			
		boolean dotFound = false; // Flag To Check For Multiple Dots
			
		double first = 0; // First Number
			
		double second = 0; // Second Number
			
		boolean add = false; // Addition Flag
		
		boolean sub = false; // Subtraction Flag
			
		boolean mult = false; // Multiplication Flag
		
		boolean div = false; // Division Flag
			
		int pos = 0; // Position Index
			
		Character tmp; // Temp Char To Hold The Current Char To Analyze
			
		double res = 0; // Final Result
			
		String result = ""; // Return Value
			
		// Read First Number
		for (int i = 0; i < lenght; i++) {
			
			tmp = line.charAt(i); // Char At Position i
			
			result += tmp;
				
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
				
			return ("# Error: Wrong Input At Pos " + pos + " !!!" + result + "|");
				
		}
			
		if (line.charAt(pos) == '+') { // Looks For Addition
				
			add = true; // Addition Found				
				
		}
			
		if (line.charAt(pos) == '-') { // Looks For Subtraction
				
			sub = true; // Subtraction Found				
				
		}

		if (line.charAt(pos) == '*') { // Looks For Multiplication
	
			mult = true; // Multiplication Found				
	
		}

		if (line.charAt(pos) == '/') { // Looks For Division
	
			div = true; // Division Found				
	
		}
			
		if (add && sub && mult && div) { // Wrong Char At Operation Position
				
			return ("# Error: Wrong Input At Pos " + pos + "Char at pos: " + line.charAt(pos) + " !!!" + result + "||");
				
		}
			
		pos ++; // Go To The Next Expression
				
					
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
		
		if (sub) { // Subtraction
			
			res = first - second;
				
		}
			
		if (mult) { // Multiplication
				
			res = first*second;
				
		}
		
		if (div) { // Addition
			
			if (second == 0) {
				
				return ("# Error: Wrong Input, Cannot Divide By Zero !!!");
				
			} else {
				
				res = first / second;
			
			}	
				
		}
			
		result = "" + res; // To String
			
		return result; // Return
			
	}
	

}
