package problem04;

/*
Largest palindrome product
Problem 4
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.

Find the largest palindrome made from the product of two 3-digit numbers.
*/

public class LargestPalindrome {
   public static void main(String[] args) {
      int largestPalindrome = 0, value = 0;
      String palindrome = "";
      for (int one = 1; one <= 999; one++) {
         for (int two = 1; two <= 999; two++) {
            value = one * two;
            palindrome = "" + value;
            if (palindromeTest(palindrome) && value > largestPalindrome) {
               largestPalindrome = value;
            }
         }
      }
      System.out.print(largestPalindrome);
   }

   public static boolean palindromeTest(String s) {
      String s2 = "";
      for (int i = s.length() - 1; i >= 0; i--) {
         s2 += s.charAt(i);
      }
      if (s2.equals(s)) {
         return true;
      }
      return false;
   }
}