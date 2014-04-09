package problem34;

/*
 Digit factorials
 Problem 34
 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.

 Find the sum of all numbers which are equal to the sum of the factorial
 of their digits.

 Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class DigitFactorials {
   
   private static int[] factorials = new int[10];
   static {
      factorials[0] = 1;
   }
   private static int upperBound;
   public static void main(String[] args) {
      
      // generate factorials
      for (int i = 1; i < 10; i++) {
         factorials[i] = i * factorials[i - 1];
      }
      upperBound = 7 * factorials[9]; 
      
      // search
      int sum = 0;
      for (int i = 3; i < upperBound; i++) {
         String s = (String.valueOf(i));
         int value = i;
         int desiredDigit = value;
         for (int j = 0; j < s.length(); j++, desiredDigit /= 10) {
            value -= factorials[desiredDigit % 10];
         }
         if (value == 0) {
            sum += i;
         }
      }
      System.out.println(sum);
   }

}
