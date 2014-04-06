package problem01;

/*
 Multiples of 3 and 5
 Problem 1
 If we list all the natural numbers below 10 that are multiples of 3 or 5, we get
 3, 5, 6 and 9. The sum of these multiples is 23. Find the sum of all the multiples
  of 3 or 5 below 1000.
 */

public class MultiplesOf {
   public static void main(String[] args) {
      System.out.println(sumMultiples(3, 5, 1000));
   }

   private static int sumMultiples(int first, int second, int max) {
      int sum = 0;
      for (int i = 0; i < max; i++) {
         if (i % first == 0 || i % second == 0) {
            sum += i;
         }
      }
      return sum;
   }
}
