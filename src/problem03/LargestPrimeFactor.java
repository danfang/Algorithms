package problem03;

/*
Largest prime factor
Problem 3
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
*/

public class LargestPrimeFactor {
   public static void main(String[] args) {
      long factorNumber = 600851475143L;
      int largestFactor = 1, testNumber = 1;
      while (testNumber < Math.sqrt(factorNumber)) {
         // if the tested number is prime and is a factor
         if (primeTest(testNumber) && factorNumber % testNumber == 0) {
            largestFactor = testNumber;
         }
         testNumber += 2;
      }
      System.out.println(largestFactor);
   }

   public static boolean primeTest(int number) {
      int root = (int) Math.ceil(Math.sqrt(number));
      for (int i = 2; i < root + 1; i++) {
         if ((double) number % i == 0) {
            return false;
         } else if (i == root) {
            return true;
         }
      }
      return false;
   }
}