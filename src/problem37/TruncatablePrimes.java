package problem37;

/*
 Truncatable Primes
 Problem 37
 The number 3797 has an interesting property. Being prime itself, it is possible
 to continuously remove digits from left to right, and remain prime at each
 stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797,
 379, 37, and 3.

 Find the sum of the only eleven primes that are both truncatable from left 
 to right and right to left.

 NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

import java.util.List;

import problem07.PrimeNumbers;
import problem35.SieveEratosthenes;

public class TruncatablePrimes {

   // gets primes under 1000000
   private static List<Integer> primes = SieveEratosthenes.getPrimeArray(1000000);

   public static void main(String[] args) {
      int sum = 0;
      int found = 0;
      for (int i = 5; i < primes.size() && found < 11; i++) {
         int prime = primes.get(i);
         if (truncateTest(prime)) {
            sum += prime;
            found++;
         }
      }
      System.out.println(sum);
   }

   private static boolean truncateTest(int number) {
      // truncates left by dividing by 10 progressively
      int truncateLeft = number / 10;
      while (truncateLeft != 0) {
         if (!PrimeNumbers.primeTest(truncateLeft)) {
            return false;
         }
         truncateLeft /= 10;
      }
      // truncates from right to left by taking the greatest modulus
      // e.g. 3797 % 10^3 = 797. 797 % 10^2 = 97. 97 % 10 = 7...
      int truncateRight = number % (int) Math.pow(10, ("" + number).length() - 1);
      while (truncateRight >= number % 10) {
         if (!PrimeNumbers.primeTest(truncateRight)) {
            return false;
         }
         truncateRight = truncateRight
               % (int) Math.pow(10, ("" + truncateRight).length() - 1);
      }
      return true;
   }

}
