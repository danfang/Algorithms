package problem17;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
*/

public class NumberLetterCounts {

   private static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
   static {
      // 0 ... 10
      map.put(0, 0); map.put(1, 3); map.put(2, 3);map.put(3, 5); map.put(4, 4); map.put(5, 4);
      map.put(6, 3);map.put(7, 5); map.put(8, 5); map.put(9, 4); map.put(10, 3);
      // 11 ... 20
      map.put(11, 6); map.put(12, 6); map.put(13, 8); map.put(14, 8); map.put(15, 7);
      map.put(16, 7); map.put(17, 9); map.put(18, 8); map.put(19, 8); map.put(20, 6);
      // 30 ... 90
      map.put(30, 6); map.put(40, 5); map.put(50, 5); map.put(60, 5);
      map.put(70, 7); map.put(80, 6); map.put(90, 6);
      // 100, 1000
   }
   
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Print the number letter count up to: ");
      System.out.println("Sum: " + numberLetterSum(input.nextInt()));
   }
   
   // counts the number letter sum up to one million, given n
   private static int numberLetterSum(int n) {
      int sum = 0;
      for (int i = 1; i <= n; i++) {
         int value;
         if (i < 20) {           // 1 - 19
            value = map.get(i);
         } else if (i < 100) {   // 20 - 99
            value = map.get(i - (i % 10)) + map.get(i % 10);
            map.put(i, value);
         } else if (i < 1000) {  // 100 - 999
            if (i % 100 != 0) {
               value = map.get(i / 100) + "hundred".length() + "and".length() + map.get(i % 100);
            } else {             // 100, 200...
               value = map.get(i / 100) + "hundred".length();
            }
            map.put(i, value);
            
         } else { // 1000 - 999999
            if (i % 1000 != 0) {
               value = map.get(i / 1000) + "thousand".length() + "and".length() + map.get(i % 1000);
            } else {
               value = map.get(i / 1000) + "thousand".length();
            }
            map.put(i, value);
         }
         sum += value;
      }
      return sum;
   }
}