package problem35;

import java.util.List;

import problem07.PrimeNumbers;

public class CircularPrimes {

   private static List<Integer> primes = SieveEratosthenes.getPrimeArray(1000000);
   
   public static void main(String[] args) {
      int count = 0;
      for (int i: primes) {
         if (isCircular(i)) {
            count++;
         }
      }
      System.out.println(count);
   }
   
   private static boolean isCircular(int n) {
      String shift = "" + n;
      if (shift.length() == 1) {
         return true;
      }
      for (int i = 0; i < shift.length() - 1; i++) {
         shift = (shift.charAt(shift.length() - 1) + shift).substring(0, shift.length());
         if (!PrimeNumbers.primeTest(Integer.parseInt(shift))) {
            return false;
         }
      }
      return true;
   }

}
