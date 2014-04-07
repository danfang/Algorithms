import java.io.FileNotFoundException;

import problem01.MultiplesOf;
import problem02.FibonacciSum;
import problem03.LargestPrimeFactor;
import problem04.LargestPalindrome;
import problem05.SmallestMultiple;
import problem06.SumSquareDifference;
import problem07.PrimeNumbers;
import problem08.LargestProductSeries;
import problem09.PythagoreanTriplet;
import problem11.GridProduct;
import problem12.TriangleNumber;
import problem13.LargeSum;
import problem14.LongestCollatz;
import problem15.LatticePaths;
import problem16.PowerDigitSum;
import problem17.NumberLetterCounts;
import problem18.MaximumPathSum;
import problem19.CountingSundays;
import problem20.FactorialDigitSum;
import problem21.AmicableNumbers;
import problem22.NameScores;
import problem23.NonAbundantSums;

/*
 This class tests the speed of each algorithm used
 */

public class PerformanceTest {
   public static final int COMPLETED_PROBLEMS = 23;
   
   public static void main(String[] args) throws FileNotFoundException {
      runAll();
   }
   
   private static void runAll() throws FileNotFoundException {
      for(int i = 1; i <= COMPLETED_PROBLEMS; i++) {
         runClass(i);
         System.out.println();
      }
   }
   
   private static void runClass(int number) throws FileNotFoundException {
      double elapsed = System.currentTimeMillis();
      System.out.println("Problem number: " + number);
      switch (number) {
         case 1: MultiplesOf.main(null);
            break;
         case 2: FibonacciSum.main(null);
            break;
         case 3: LargestPrimeFactor.main(null);
            break;
         case 4: LargestPalindrome.main(null);
            break;
         case 5: SmallestMultiple.main(null);
            break;
         case 6: SumSquareDifference.main(null);
            break;
         case 7: PrimeNumbers.main(new String[] {"0"});
            break;
         case 8: LargestProductSeries.main(null);
            break;
         case 9: PythagoreanTriplet.main(null);
            break;
         case 10: PrimeNumbers.main(new String[] {"1"});
            break;
         case 11: GridProduct.main(null);
            break;
         case 12: TriangleNumber.main(null);
            break;
         case 13: LargeSum.main(null);
            break;
         case 14: LongestCollatz.main(null);
            break;
         case 15: LatticePaths.main(null);
            break;
         case 16: PowerDigitSum.main(null);
            break;
         case 17: NumberLetterCounts.main(new String[] {"1000"});
            break;
         case 18: 
            MaximumPathSum.main(new String[] {"src/problem18/triangle.txt", "15"});
            System.out.println("Problem number: 67");
            MaximumPathSum.main(new String[] {"src/problem18/bigTriangle.txt", "100"});
            break;
         case 19: CountingSundays.main(null);
            break;
         case 20: FactorialDigitSum.main(null);
            break;
         case 21: AmicableNumbers.main(null);
            break;
         case 22: NameScores.main(null);
            break;
         case 23: NonAbundantSums.main(null);
            break;
      }
      System.out.println("Time elapsed: " + (System.currentTimeMillis() - elapsed) + " ms");
   }
}
