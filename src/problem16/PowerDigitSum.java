package problem16;

import java.math.BigInteger;
/*
 Power Digit Sum
 Problem 16
 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 What is the sum of the digits of the number 2^1000?
*/

public class PowerDigitSum {
   public static void main(String[] args) {
      System.out.println(digitSum(2, 1000));
   }
   
   private static int digitSum(int base, int pow) {
      BigInteger bigBase = BigInteger.valueOf(base);
      BigInteger result = bigBase.pow(pow);
      String s = result.toString();
      int sum = 0;
      for (int i = 0; i < s.length(); i++) {
         sum += Integer.parseInt("" + s.charAt(i));
      }
      return sum;
   }
}
