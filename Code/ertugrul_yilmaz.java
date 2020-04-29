import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Scanner;
/** Ertuğrul Yılmaz, ID: 041701030, 16 November 2019 */
/**
 * This class includes the algorithm which is called parentheses checker. The
 * program takes file name as input from user. And checks the correctness of the
 * parentheses.
 * @author Ertuğrul Yılmaz 
 */

public class ertugrul_yilmaz {

	public static void main(String[] args) {

		// Create the which is type of string and going to hold open parentheses.
		myStack<String> open = new myStack<String>();
		// Create a scanner for input.
		Scanner input = new Scanner(System.in);
		// Take the .java file's name as input.
		String fileName = input.next();
		// Convert that file to a path to access.
		fileName = "src/" + fileName + ".java";
		// It is going to store our given java file as a String.
		String javaFile = "";
		// The name of .txt file
		String outputFileName = String.format("%s.txt", fileName.replace('.', '_'));
		//Close the scanner.
		input.close();
		// Read the given java code
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			// It is going to hold every line of java code
			String line;
			// If it is not null
			while ((line = br.readLine()) != null) {
				// Assign every line to one String
				javaFile = javaFile + line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// It is going hold the current char of java code.
		String currentChar = " ";
		// Loop for every single char of the java code.
		for (int i = 0; i < javaFile.length(); i++) {
			// Assign the current char based on for loop.
			currentChar = String.valueOf(javaFile.charAt(i));
			// If there is an open parentheses
			if (currentChar.equals("(")) {
				// Push the parentheses to stack.
				open.push(currentChar);
				// Print after every push operation.
				for (Iterator<String> x = open.iterator(); x.hasNext();) {
					String item = x.next();
					System.out.print(item + " ");
				}
				System.out.println();
			// If there is an open parentheses
			} else if (currentChar.equals("{")) {
				// Push the parentheses to stack.
				open.push(currentChar);
				// Print after every push operation.
				for (Iterator<String> x = open.iterator(); x.hasNext();) {
					String item = x.next();
					System.out.print(item + " ");
				}
				System.out.println();
			// If there a close parentheses.
			} else if (currentChar.equals(")")) {
				//First check the stack emptiness for avoid errors on peek.
				if (!(open.isEmpty()) && open.peek().equals("(")) {
					//Pop the element
					open.pop();
				//If there is close parentheses and stack is empty that means given code is not correct.
				} else {
					//Output for user.
					System.out.println("\nParentheses do not match!");
					//Terminate the program
					System.exit(1);
					break;

				}
			// If there a close parentheses.
			} else if (currentChar.equals("}")) {
				//First check the stack emptiness for avoid errors on peek.
				if (!(open.isEmpty()) && open.peek().equals("{")) {
					//Pop the element
					open.pop();
				//If there is close parentheses and stack is empty that means given code is not correct.
				} else {
					//Output for user.
					System.out.println("\nParentheses do not match!");
					//Terminate the program
					System.exit(1);
					break;

				}
			}

		}
		//After checking the given java code if stack empty that means parentheses were correct.
		if (open.isEmpty()) {
			//Output for user.
			System.out.println("\nParentheses are correct");
		//If stack is not empty that means there are parentheses which does not have a close pair.
		} else {
			//Output for user.
			System.out.println("\nParentheses do not match!");
		}
	}

}
