package problem20;

/*
 Factorial Digit Sum
 Problem 20

 n! means n × (n − 1) × ... × 3 × 2 × 1

 For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

 Find the sum of the digits in the number 100!
 */

import java.math.BigInteger;

public class FactorialDigitSum {
   public static void main(String[] args) {
      BigInteger answer = factorial(BigInteger.valueOf(100));
      String digits = answer.toString();
      int sum = 0;
      for (int i = 0; i < digits.length(); i++) {
         sum += Integer.parseInt("" + digits.charAt(i));
      }
      System.out.println(sum);
   }
   
   private static BigInteger factorial(BigInteger n) {
      if (n.compareTo(BigInteger.valueOf(1)) == 0) {
         return n;
      }
      return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
   }
}
