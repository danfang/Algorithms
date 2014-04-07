package problem21;

/*
 Amicable Numbers
 Problem 21
 Let d(n) be defined as the sum of proper divisors of n 
 (numbers less than n which divide evenly into n).
 If d(a) = b and d(b) = a, where a ≠ b, then a and b are an
 amicable pair and each of a and b are called amicable numbers.

 For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110;
 therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

 Evaluate the sum of all the amicable numbers under 10000.
 */

import java.util.Set;
import java.util.TreeSet;

public class AmicableNumbers {
   public static void main(String[] args) {
      System.out.println(getAmicableSum(10000));
   }

   // returns the sum of all divisors < n
   public static int getDivisorSum(int n) {
      Set<Integer> divisors = new TreeSet<Integer>();
      int root = (int) Math.ceil(Math.sqrt(n));
      for (int i = 1; i < root + 1; i++) {
         if ((double) n % i == 0 && i < n) {
            divisors.add(i);
            if (n / i < n) {
               divisors.add(n / i);
            }
         }
      }
      int divisorSum = 0;
      for (int i : divisors) {
         divisorSum += i;
      }
      return divisorSum;
   }
   
   // returns the sum of all amicable numbers < max
   private static int getAmicableSum(int max) {
      int sum = 0;
      for (int i = 1; i < max; i++) {
         int a = getDivisorSum(i);
         int b = getDivisorSum(a);
         if (i == b && a != b) {
            sum += i;
         }
      }
      return sum;
   }
}
