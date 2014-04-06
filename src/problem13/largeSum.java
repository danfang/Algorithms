package problem13;

/*
Large sum
Problem 13
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

The numbers are stored in a file called "list.txt"
*/

import java.util.Scanner;
import java.io.*;
public class largeSum{
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("list.txt"); // "list.txt" is the file with all the numbers
		Scanner scan = new Scanner(f);
		int[][] list = new int[100][50]; // 2-dimensional array to hold one-hundred 50-digit numbers
		String[] s = new String[100]; // each line in the file is a String -- this array holds the 100 Strings
		
		/*
		the method "putIntoArray" takes the following parameters: the array s[], the array list[][], and the file scanner.
		It takes all the lines from file "list.txt", and puts the individual numbers into list[][].
		*/
		
		putIntoArray(s, list, scan);
		
		
		/* 
		This for loop adds up the columns starting with the very last one (column 49),
		and then carries the digitHolder (sum/10) over to the next column. This emulates addition by hand,
		where the sums are carried over if they are greater than 10. Then, the remainder (the sum % 10) is stored
		in an array. For example, if column 49 adds up to 486, then 48 (486/10) is carried over to column 48, while 
		6 (486 % 10)is stored as the remainder. At the very end, we end up with the 'digitHolder', and an array of 
		50 remainder values.
		*/
		
		int digitHolder = 0;
		int[] remainderHolder = new int[50];
		for(int i = 49; i >= 0; i--){ // i is the column 
			for(int j = 0; j < 100; j++){ // j is the row
				digitHolder += list[j][i]; // numbers are added down column 'i'
			}
			remainderHolder[i] = digitHolder % 10; // the remainder
			digitHolder /= 10; // the sum to be carried over
		}
		System.out.print("The total sum is " + digitHolder);
		for(int i = 0; i < 50; i++){
			System.out.print(remainderHolder[i]);
		}
	} // end of main method
	
	public static void putIntoArray(String[] s, int[][]list, Scanner scan){
		for(int i = 0; i < s.length; i++){
			s[i] = scan.nextLine(); // scans each line from the file into s[]
			for(int j = 0; j < s[i].length(); j++){
				String character = "" + s[i].charAt(j);
				list[i][j] = Integer.parseInt(character); // parses the characters into ints, and stores into list[][]
			}
		}
	} // end of putIntoArray
} // end of largeSum