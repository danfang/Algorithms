package problem07;

/* This program is based on the following "Project Euler" problem:

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10,001st prime number?

The program prompts the user to test either a number's primality, or find a certain prime number.
*/

import java.util.Scanner;

public class PrimeNumbers {

   private static Scanner scan = new Scanner(System.in);

   public static void main(String[] args) {
      boolean run = true;
      if (args.length == 0) {
         while (run) {
            printInstructions();
            String choice = scan.next();
            System.out.println();
            if (choice.equalsIgnoreCase("t")) {
               System.out.print("Please enter a number to test: ");
               int testNumber = scan.nextInt();
               System.out.println("Is " + testNumber + " a prime number? "
                     + primeTest(testNumber));
            } else if (choice.equalsIgnoreCase("f")) {
               System.out.print("Which prime number do you wish to find?(#) ");
               int numberOfPrimes = scan.nextInt();
               int answer = findPrime(numberOfPrimes);
               System.out.println(answer + " is the " + numberOfPrimes
                     + numberType(numberOfPrimes) + " prime number. ");
            } else if (choice.equalsIgnoreCase("s")) {
               System.out.println("Find the sum of all primes below: ");
               int max = scan.nextInt();
               System.out.println("Answer: " + findPrimeSumUnderValue(max));
            } else if (choice.equalsIgnoreCase("q")) {
               run = false;
            } else {
               System.out.println("I'm sorry. Please choose one of the options.");
            }
         }
      } else {
         if (args[0].equals("0")) { // problem 7
            System.out.println(findPrime(10001));
         } else if (args[0].equals("1")) {
            System.out.println(findPrimeSumUnderValue(2000000));
         }
      }
   }

   // returns whether or not a given number is prime
   public static boolean primeTest(int number) {
      if (number == 2) {
         return true;
      }
      // tests up to the square root of the number
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
   
   // answers Euler problem 10, "find the sum of all primes below n"
   private static long findPrimeSumUnderValue(int max) {
      long sum = 0;
      for (int i = 2; i < max; i++) {
         if (primeTest(i)) {
            sum += i;
         }
      }
      return sum;
   }

   // TODO: Replace with Sieve of Eratosthenes
   private static int findPrime(int numberOfPrimes) {
      if (numberOfPrimes == 1) {
         return 2;
      }
      int primeCount = 1;
      int testNumber = 3;
      while (primeCount < numberOfPrimes) {
         if (primeTest(testNumber)) {
            primeCount++;
         }
         if (primeCount == numberOfPrimes) {
            return testNumber;
         }
         testNumber += 2; // only odd numbers are tested
      }
      return -1;
   }

   // PROGRAM PROMPT ITEMS
   
   private static void printInstructions() {
      System.out.println("This program deals with prime numbers. You can do one of four things.");
      System.out.println("\t't' to test for primality\n" +
                         "\t'f' to find a prime number\n"+
                         "\t's' to find the summation of all prime numbers below a given value\n" +
                         "\t'q' to quit the program.");
      System.out.print("Choice: ");
   }

   private static String numberType(int number) {
      if (number % 100 == 10 || number % 100 == 11 || number % 100 == 13) {
         return "th";
      } else if (number % 10 == 1) {
         return "st";
      } else if (number % 10 == 2) {
         return "nd";
      } else if (number % 10 == 3) {
         return "rd";
      } else {
         return "th";
      }
   }
}