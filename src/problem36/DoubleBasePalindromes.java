package problem36;

/*
 Double-base palindromes
 Problem 36
 The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.

 Find the sum of all numbers, less than one million, which are palindromic in base
 10 and base 2.

 (Please note that the palindromic number, in either base, may not include 
 leading zeros.)
 */

import problem04.LargestPalindrome;

public class DoubleBasePalindromes {

   public static void main(String[] args) {
      int sum = 0;
      for (int i = 1; i < 1000000; i += 2) {
         if (LargestPalindrome.palindromeTest("" + i)
               && LargestPalindrome.palindromeTest(Integer.toBinaryString(i))) {
            sum += i;
         }
      }
      System.out.println(sum);
   }
}
