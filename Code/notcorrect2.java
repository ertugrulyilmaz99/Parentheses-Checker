/** Ertuğrul Yılmaz, ID: 041701030, 16 November 2019 
 * A class with wrong parentheses.*/
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class readingFiles {
	public static void main(String[] args) {
		/**
		 * @author Zeynep Y�lmaz
		 * @since  24-02-2019
		 * This program is loading the text file into an array; sorts the array and finds the most frequent numbers.
		 */
		String file= "data2.txt"; // This line is important because before that, I couldn't see the array.
		int[] numbers = loadNumbers("data2.txt");
		System.out.println(Arrays.toString(numbers)); //This line is printing array output.
		// creates frequency array. frequency array stores
		// the frequency of numbers. assume that numbers
		// are in the range of [0..999]. length of frequency
		// array is 1000.
		int[] frequency = computeFrequency(numbers);
		// display the most frequent numbers
	} 
	public static int[] computeFrequency(int[] numbers) { // it has to take int[] numbers array as an input. 
		int x=0; // use x and w to find the other frequent number.
		int w=0;
		int number =0;
		int count=0; // This will show the frequency of our most frequent number.
		for(int i=0; i<numbers.length; i++) {
			int numberHolder= numbers[i]; //numberHolder will hold the number from array and it will count with countTwo.
			int countTwo=0;
			for(int j=0; j<numbers.length; j++) {
				if(numbers[j]==numberHolder)
					countTwo++;
				if(countTwo>count) { //if it's greater than the previous number, it means I found most frequent number.
					number=numberHolder;
					count=countTwo;
				}
			}  
			for(int k=0; k<numbers.length; k++) {
				if((countTwo==count) && (numberHolder != number)) { 
					x=numberHolder;
					w=countTwo;
				} /*else { 
					x=0;
					w=0;
				}*/
			}
		}
		/**
		 * I had a problem when I run this with data1. Program couldn't find the other frequent numbers in data1 text file. 
		 * Program also had a problem to compare numbers, it gave the wrong output. I mentioned this on my report.
		 */
		System.out.println("Most Frequent Elements: ");
		System.out.println("Number: " + number + "," + " Frequency: " + count); 
		System.out.println("Number: " + x + "," + " Frequency: " + w); 
		return null;
	}
	public static int[] loadNumbers(String file) {
		try {
			File myFile= new File (file);
			Scanner input = new Scanner(myFile);
			int counter=0; // I have to know how big my file is.
			while (input.hasNextInt()) { // while loop will access the file and count the integers with s.nextInt() one by one.
				counter++;
				input.nextInt();
			}
			System.out.println("Amount of integers in " + file + " file: " + counter);
			int[] myArray = new int[counter];
			Scanner input2= new Scanner (myFile);
			for (int i=0; i<myArray.length; i++
				myArray[i]=input2.nextInt();
			//System.out.println(Arrays.toString(myArray)); 
			// for loop is going to load the integers into array.
			return myArray;
		} 
		catch(Exception e) {
			return null;
		} 
	}
}