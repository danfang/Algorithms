package problem05;

/*
Smallest multiple
Problem 5
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

public class SmallestMultiple {
   public static void main(String[] args) {
      boolean multipleTest = false;
      int i = 0;
      while (!multipleTest) {
         for (int j = 1; j <= 20; j++) {
            if ((double) i % j != 0) {
               multipleTest = false;
               break;
            }
            if ((double) i % j == 0 && j == 20 && i != 0) {
               multipleTest = true;
            }
         }
         i += 20;
      }
      System.out.println(i - 20);
   }
}