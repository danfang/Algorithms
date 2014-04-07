package problem23;

/*
 Non-abundant sums
 Problem 23

 A perfect number is a number for which the sum of its proper divisors is exactly
 equal to the number. For example, the sum of the proper divisors of 28 would be
 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

 A number n is called deficient if the sum of its proper divisors is less than n and 
 it is called abundant if this sum exceeds n.

 As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number
 that can be written as the sum of two abundant numbers is 24. By mathematical analysis,
 it can be shown that all integers greater than 28123 can be written as the sum of two
 abundant numbers. However, this upper limit cannot be reduced any further by analysis
 even though it is known that the greatest number that cannot be expressed as the sum
 of two abundant numbers is less than this limit.

 Find the sum of all the positive integers which cannot be written as the sum of two
 abundant numbers.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import problem21.AmicableNumbers;

public class NonAbundantSums {
   private static final int CAP = 28123;

   public static void main(String[] args) {
      Set<Integer> abundantNumbers = getAbundantNumbers(CAP);
      Set<Integer> abundantSums = getAbundantSums(abundantNumbers, CAP);

      int nonAbundantSum = 0;
      for (int i = 0; i < CAP; i++) {
         if (!abundantSums.contains(i)) {
            nonAbundantSum += i;
         }
      }
      System.out.println(nonAbundantSum);
   }

   // returns a set of all abundant numbers below max
   private static Set<Integer> getAbundantNumbers(int max) {
      Set<Integer> s = new TreeSet<Integer>();
      for (int i = 0; i < max; i++) {
         if (AmicableNumbers.getDivisorSum(i) > i) {
            s.add(i);
         }
      }
      return s;
   }

   // note: removes all values from the set "abundantNumbers" in order to find sums
   private static Set<Integer> getAbundantSums(Set<Integer> abundantNumbers, int max) {
      Set<Integer> s = new HashSet<Integer>();
      Iterator<Integer> iterator;
      // performs a "bubble" sum, summing all numbers including and after "first"
      while (abundantNumbers.size() != 0) {
         iterator = abundantNumbers.iterator();
         int first = iterator.next();
         if (2 * first < max) {
            s.add(first + first);
         }
         iterator.remove();
         while (iterator.hasNext()) {
            int sum = first + iterator.next();
            if (sum < max) {
               s.add(sum);
            }
         }
      }
      return s;
   }
}
