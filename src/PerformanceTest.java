
import java.lang.reflect.Method;

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
import problem24.LexicographicPermutations;
import problem25.Fibonacci1000;
import problem27.QuadraticPrimes;
import problem28.SpiralDiagonals;
import problem29.DistinctPowers;
import problem30.DigitFifthPowers;
import problem32.PandigitalProducts;
import problem33.DigitCancelingFractions;
import problem34.DigitFactorials;
import problem35.CircularPrimes;
import problem36.DoubleBasePalindromes;
import problem37.TruncatablePrimes;
import problem38.PandigitalMultiples;
import problem54.HandParser;

/*
 This class tests the speed of each algorithm used
 */

public class PerformanceTest {
   private static final Object[] classes = {
         // PROBLEMS 1 - 9
         new MultiplesOf(),       new FibonacciSum(),         new LargestPrimeFactor(),
         new LargestPalindrome(), new SmallestMultiple(),     new SumSquareDifference(),
         new PrimeNumbers(),      new LargestProductSeries(), new PythagoreanTriplet(),
         // PROBLEMS 10 - 18
         new PrimeNumbers(),      new GridProduct(),          new TriangleNumber(), 
         new LargeSum(),          new LongestCollatz(),       new LatticePaths(), 
         new PowerDigitSum(),     new NumberLetterCounts(),   new MaximumPathSum(), 
         // PROBLEMS 19 - 27
         new CountingSundays(),   new FactorialDigitSum(),    new AmicableNumbers(),        
         new NameScores(),        new NonAbundantSums(),      new LexicographicPermutations(), 
         new Fibonacci1000(),     null,                       new QuadraticPrimes(), 
         // PROBLEMS 28 - 36
         new SpiralDiagonals(),   new DistinctPowers(),       new DigitFifthPowers(),
         null,                    new PandigitalProducts(),   new DigitCancelingFractions(),
         new DigitFactorials(),   new CircularPrimes(),       new DoubleBasePalindromes(),
         // PROBLEMS 37 - 45
         new TruncatablePrimes(), new PandigitalMultiples()
      };
   
   // indexes correspond to problem number (not 0-based)
   private static String[][] arguments = new String[300][];
   static {
      arguments[7] = new String[] {"0"};
      arguments[10] = new String[] {"1"};
      arguments[17] = new String[] {"0"};
      arguments[18] = new String[] { "src/problem18/triangle.txt", "15" };
   }
   
   public static void main(String[] args) throws Exception {
      //runAll();
      //run(5);
      //run(new HandParser(), new String[]{});
   }

   private static void runAll() throws Exception {
      for (int i = 1; i <= classes.length; i++) {
         run(i);
      }
   }

   private static void run(int number) throws Exception {
      if (classes[number - 1] != null) {
         System.out.println("Problem number: " + number);
         Method m = classes[number - 1].getClass().getMethod("main", String[].class);
         double elapsed = System.currentTimeMillis();
         m.invoke(classes[number - 1], (Object) arguments[number]);
         System.out.println("Time elapsed: " + (System.currentTimeMillis() - elapsed + 1) + " ms");
         System.out.println();
      }
   }

   private static void run(Object o, String[] args) throws Exception {
      double elapsed = System.currentTimeMillis();
      o.getClass().getMethod("main", String[].class).invoke(o, (Object) args);
      System.out.println("Time elapsed: " + (System.currentTimeMillis() - elapsed + 1) + " ms");
   }
}
