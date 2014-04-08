package problem25;

/*
 1000-digit Fibonacci number
 Problem 25
 What is the first term in the Fibonacci sequence to contain 1000 digits?
 */

import java.math.BigInteger;

public class Fibonacci1000 {
   
   public static void main(String[] args) {
      System.out.println(find());
   }

   private static int find() {
      int count = 2;
      BigInteger first = BigInteger.valueOf(1);
      BigInteger second = BigInteger.valueOf(1);
      while (String.valueOf(second).length() != 1000) {
         BigInteger temp = first;
         first = second;
         second = first.add(temp);
         count++;
      }
      return count;
   }
}