package problem33;

/*
 Digit cancelling fractions
 Problem 33
 The fraction 49/98 is a curious fraction, as an inexperienced mathematician in
 attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is
 correct, is obtained by cancelling the 9s.

 We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

 There are exactly four non-trivial examples of this type of fraction, less than one
 in value, and containing two digits in the numerator and denominator.

 If the product of these four fractions is given in its lowest common terms, 
 find the value of the denominator.
 */
public class DigitCancelingFractions {

   public static void main(String[] args) {
      double totalNum = 1;
      double totalDen = 1;
      for (int i = 10; i < 99; i++) {
         for (int j = 10; j < 99; j++) {
            if ((double) i / j == cancel(i, j)) {
               totalNum *= i;
               totalDen *= j;
            }
         }
      }
      System.out.println((int) (1 / (totalNum / totalDen)));
   }

   // returns the result of dividing the num by the den after canceling
   // common numbers, if there is a cancellation. Otherwise, returns -1.
   private static double cancel(int num, int den) {
      // does not include numbers that end in 0, or are greater than 1
      if (num % 10 == 0 && den % 10 == 0 || num / den != 0) {
         return -1.0;
      }
      if (num % 10 == den % 10) {
         return (double) (num / 10) / (den / 10);
      } else if (num % 10 == den / 10) {
         return (double) (num / 10) / (den % 10);
      } else if (num / 10 == den % 10) {
         return (double) (num % 10) / (den / 10);
      } else if (num / 10 == den / 10) {
         return (double) (num % 10) / (den % 10);
      }
      // no matching numbers
      return -1.0;
   }
}