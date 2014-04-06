package problem13;

/*
Large sum
Problem 13
Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.

The numbers are stored in a file called "list.txt"
*/

import java.util.Scanner;
import java.io.*;
public class LargeSum{
   
	public static void main(String[] args) throws FileNotFoundException{
		File f = new File("src/problem13/list.txt"); // "list.txt" is the file with all the numbers
		Scanner scan = new Scanner(f);
		int[][] list = new int[100][50];
		String[] s = new String[100]; // stores each line in the file
		
		putIntoArray(s, list, scan);

      int digitHolder = 0;
      int[] remainderHolder = new int[50];
      for (int i = 49; i >= 0; i--) { // i is the column
         for (int j = 0; j < 100; j++) { // j is the row
            digitHolder += list[j][i]; // numbers are added down column 'i'
         }
         remainderHolder[i] = digitHolder % 10; // the remainder
         digitHolder /= 10; // the sum to be carried over
      }
      System.out.print("The total sum is " + digitHolder);
      for (int i = 0; i < 50; i++) {
         System.out.print(remainderHolder[i]);
      }
   }

   public static void putIntoArray(String[] s, int[][] list, Scanner scan) {
      for (int i = 0; i < s.length; i++) {
         s[i] = scan.nextLine(); // scans each line from the file into s[]
         for (int j = 0; j < s[i].length(); j++) {
            String character = "" + s[i].charAt(j);
            list[i][j] = Integer.parseInt(character);
         }
      }
   }
}