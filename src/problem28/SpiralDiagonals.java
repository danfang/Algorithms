package problem28;

/*
 Number spiral diagonals
 Problem 28
 Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5
 spiral is formed as follows:

          21 22 23 24 25
          20  7  8  9 10
          19  6  1  2 11
          18  5  4  3 12
          17 16 15 14 13

 It can be verified that the sum of the numbers on the diagonals is 101.

 What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral
 formed in the same way?
 */

public class SpiralDiagonals {
   public static void main(String[] args) {
      System.out.println(findSpiralDiagonalSum(1001));
   }

   // method 1: keep track of all spiral addition (+2 four times, +4 four times, etc) 
   private static int findSpiralDiagonalSum(int dimension) {
      int currentNumber = 1;
      int diagonalSum = 1;
      for (int i = 1; i < dimension; i += 2) {
         for (int k = 0; k < 4; k++) {
            currentNumber += i + 1;
            diagonalSum += currentNumber;
         }
      }
      return diagonalSum;
   }
   
   // method 2: corners can be described as n^2, n^2 - n + 1, n^2 - 2n + 2, n^2 - 3n + 3,
   // thus the corners of one "layer" are 4n^2 - 6n + 6. Summation of layers from 3 to 1001
   private static int findSpiralDiagonalSum2(int dimension) {
      int sum = 1;
      for(int i = 3; i <= dimension; i+=2) {
         sum += ((4 * i * i) - (6 * i) + 6);
      }
      return sum;
   }
}
