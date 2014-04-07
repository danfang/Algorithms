package problem27;

/*
 Quadratic primes
 Problem 27
 Euler discovered the remarkable quadratic formula:
 n^2 + n + 41

 It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly 
 when n = 41, 41² + 41 + 41 is clearly divisible by 41.

 The incredible formula  n^2 − 79n + 1601 was discovered, which produces 80 primes for the
 consecutive values n = 0 to 79. The product of the coefficients, −79 and 1601, is −126479.

 Considering quadratics of the form:

 n^2 + an + b, where |a| < 1000 and |b| < 1000

 where |n| is the modulus/absolute value of n
 e.g. |11| = 11 and |−4| = 4
 Find the product of the coefficients, a and b, for the quadratic expression that produces
 the maximum number of primes for consecutive values of n, starting with n = 0.
 */
import problem07.PrimeNumbers;

public class QuadraticPrimes {
   
   private static final int MAX = 1000;
   public static void main(String[] args) {
      int maxChain = 0;
      int maxA = 0;
      int maxB = 0;
      for (int a = -MAX + 1; a < MAX; a++) {
         for (int b = -MAX + 1; b < MAX; b++) {
            int chain = 0;
            int n = 0;
            while (PrimeNumbers.primeTest((int) Math.pow(n, 2) + (a * n) + b)) {
               chain++;
               n++;
            }
            if (chain > maxChain) {
               maxChain = chain;
               maxA = a;
               maxB = b;
            }
         }
      }
      System.out.println("Max chain of: " + maxChain + " a = " + maxA + " b = " + maxB);
      System.out.println("a * b = " + maxA * maxB);
   }
}
