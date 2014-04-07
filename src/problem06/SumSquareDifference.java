package problem06;

/*
 Sum square difference
 Problem 6
 The sum of the squares of the first ten natural numbers is,

 1^2 + 2^2 + ... + 10^2 = 385
 The square of the sum of the first ten natural numbers is,

 (1 + 2 + ... + 10)^2 = 55^2 = 3025
 Hence the difference between the sum of the squares of the first ten natural numbers and
 the square of the sum is 3025-385 = 2640.

 Find the difference between the sum of the squares of the first one hundred natural numbers
 and the square of the sum.
 */

public class SumSquareDifference {
   public static final int NUMBER_OF_ITERATIONS = 100;

   public static void main(String[] args) {
      int sumOfSquares = 0;
      int sum = 0;
      for (int i = 1; i <= NUMBER_OF_ITERATIONS; i++) {
         sumOfSquares += (i * i);
         sum += i;
      }
      System.out.println((sum * sum) - sumOfSquares);
   }
}