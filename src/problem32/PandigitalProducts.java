package problem32;

/*
 Pandigital products
 Problem 32
 We shall say that an n-digit number is pandigital if it makes use of all the
 digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

 The product 7254 is unusual, as the identity, 39 x 186 = 7254, containing multiplicand,
 multiplier, and product is 1 through 9 pandigital.

 Find the sum of all products whose multiplicand/multiplier/product identity can be 
 written as a 1 through 9 pandigital.

 HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */

import java.util.HashSet;
import java.util.Set;

public class PandigitalProducts {

   private static Set<Integer> products = new HashSet<Integer>();
   
   public static void main(String[] args) {
      testRange(12, 98, 123, 987); // numbers with range xx * xxx  = xxxx can work
      testRange(1, 9, 1234, 9876); // numbers with range x * xxxx = xxxxx can work
      int productSum = 0;
      for (int i: products) {
         productSum += i;
      }
      System.out.println(productSum);
   }
   
   private static void testRange(int low, int high, int low2, int high2) {
      for (int i = low; i <= high; i++) {
         for (int j = low2; j <= high2; j++) {
            if (allowedMultipliers(i, j) && validPandigital(i, j, i * j)) {
               products.add(i * j);
            }
         }
      }
   }
   
   private static boolean allowedMultipliers(int m1, int m2) {
      int r1 = m1 % 10;
      int r2 = m2 % 10;
      // note numbers cannot be multiples of 10, or end in 1
      // multiplying a number that ends in 1 will create another 1
      return !(r1 == 0 || r1 == 1 || r2 == 0 || r2 == 1);
   }
   
   private static boolean validPandigital(int m1, int m2, int product) {
      String s = m1 + "" + m2 + "" + product;
      if (s.length() != 9) {
         return false;
      }
      for (int i = 1; i <= 9; i++) { // contains digits 1 - 9
         if (!s.contains(String.valueOf(i))) {
            return false;
         }
      }
      return true;
   }
}
