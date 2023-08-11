package com.tts.userValidator;

import java.io.*;

public class UserDataValidator {

	public static void main(String[] args) {
		
		// Inside a try block, instantiate 3 separate objects: a 'reader' that reads the
		// data inside user_data.txt, a 'validWriter' for
		// writing to a file with all the valid data,
		// and an errorWriter for writing to a file with all the faulty data.
		// If this try block fails, it would have to be because of an error from
		// instantiating these readers (e.g. file not found, I/O exception, etc.), so
		// just print the error to the console
		
		BufferedReader reader = null;
		BufferedWriter validWriter = null;
		BufferedWriter errorWriter = null;
		
		try {
			reader = new BufferedReader(new FileReader("src\\com\\tts\\data\\user_data"));
			validWriter = new BufferedWriter(new FileWriter("src\\com\\tts\\data\\valid_data.txt"));
			errorWriter = new BufferedWriter(new FileWriter("src\\com\\tts\\data\\error_data.txt"));
			
			String data;
			
			while ((data = reader.readLine()) != null) {
				
				try {
					String[] vars = data.split(",");
					
					if (vars.length < 3) {
						throw new Exception("Missing Data!");
					}
					
					String name = vars[0].trim();
					String email = vars[1].trim();
					int age = Integer.parseInt(vars[2].trim());
					
					if (age <= 0) {
						throw new Exception("Invalid Age!");
					}
					
					validWriter.write(data + "\n");
					
				} 
				catch (Exception e) {
					errorWriter.write(data + " contains the error: " + e.getMessage() + "\n");
				}
				
			}
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			try {
				reader.close();
				validWriter.close();
				errorWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
			// Run a while loop that iterates through each line of the file


				// In another try / catch block (inside the while loop), do the following:
				// 1. Use the .split() method on the current line on "," so we can get an array
				// of the name, email, and age of each user
				// 2. If the length of the array is different than 3, we know something is wrong
				// so throw an exception with message "Missing Data"
				// 3. Save each piece of data in the array to its own variable, making sure to
				// trim them of whitespace with .trim() and casting them to the correct datatype
				// (Email + Name are strings, Age is int)
				// 4. If age is less than or equal to 0, throw an exception with message
				// "Invalid Age"
				// 5. If the line passed all of these checks, write the line with the
				// validWriter!
				// 6. In the catch block, write the faulty line with the errorWriter appended
				// with the error message!

		// After the last catch statement, use a finally statement to close out of all
		// of your readers and writers. This will require another try/catch block ;)
		
	}
	
}
