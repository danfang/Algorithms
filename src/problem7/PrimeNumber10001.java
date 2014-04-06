package problem7;

/* This program is based on the following "Project Euler" problem:

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
What is the 10,001st prime number?

The program prompts the user to test either a number's primality, or find a certain prime number.
*/

import java.util.Scanner;
public class PrimeNumber10001{
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean printedInstructions = false;
		while(true){
			if(printedInstructions == false){
				printInstructions();
				printedInstructions = true;
			} else {
				System.out.println();
				System.out.println("Type 't' to test for primality, or 'f' to find a prime number.");
				System.out.println("Typing 'q' will quit the program.");
				System.out.print("Choice: ");
			}
			String choice = scan.next();
			System.out.println();
			if(choice.compareToIgnoreCase("t") == 0){
				System.out.print("Please enter a number to test: ");
				int testNumber = scan.nextInt();
				System.out.println("Is " + testNumber + " a prime number? " + primeTest(testNumber));
			} else if (choice.compareToIgnoreCase("f") == 0){
				System.out.print("Which prime number do you wish to find?(#) ");
				int numberOfPrimes = scan.nextInt();
				findPrime(numberOfPrimes);
			} else if (choice.compareToIgnoreCase("q") == 0){
				System.out.println("Goodbye.");
				break;
			} else{
				System.out.println("I'm sorry. Please choose one of the options.");
			}
		}
		//System.out.print("Which prime number do you wish to know?(#) ");
		//int numberOfPrimes = 0;
	} // end of main method
	public static boolean primeTest(int number){
		for(int i = 2; i < number; i++){
			if((double)number % i == 0){
				return false;
			} else if(i == number - 1){
				return true;
			}
		}
		return false;
	}
	public static void printInstructions(){
		System.out.println("This program deals with prime numbers. You can do one of two things.");
		System.out.println("You can either test a number for primality (returns true or false)");
		System.out.println("or find a certain prime number. For example, if you enter the number");
		System.out.println("\"6,\" the program will print \"13,\" which is the 6th prime number.");
		System.out.println("Type 't' to test for primality, or 'f' to find a prime number.");
		System.out.println("Typing 'q' will quit the program.");
		System.out.print("Choice: ");
	}
	public static String numberType(int number){
		if(number%100 == 10 || number%100 == 11 || number%100 == 13){
			return "th";
		} else if(number % 10 == 1){
			return "st";
		} else if (number % 10 == 2){
			return "nd";
		} else if (number % 10 == 3){
			return "rd";
		} else {
			return "th";
		}	
	}
	public static void findPrime(int numberOfPrimes){
		int primeCount = 1, testNumber = 1; // primeCount starts at 1, because 2 is not tested
		while(primeCount < numberOfPrimes){
			boolean primeNumber = false, isDivisible = false;
			while(primeNumber == false || isDivisible == false){ // if a prime number is found OR a number is proven to be non-prime, exit
				int root = (int)Math.ceil(Math.sqrt(testNumber));
				for(int i = 2; i < root + 1; i++){ // divides testNumber by (2) through (testNumber - 1)
					if((double)testNumber % i == 0){
						isDivisible = true; // testNumber is proven to be a non-prime number, primeCount is NOT incremented
						i = testNumber; // ends the for loop
					} else if(i == root){ // if the loop reaches the last number (testNumber - 1)
						primeNumber = true; // testNumber is proven to be a prime number, primeCount is incremented
						primeCount++;
					}
				}
			if(primeCount == numberOfPrimes){
				break;
			}
			testNumber += 2; // only odd numbers are tested
			}
		} // end of while
		if(numberOfPrimes == 1){
			testNumber = 2;
		}
		System.out.println(testNumber + " is the " + numberOfPrimes + numberType(numberOfPrimes) + " prime number. ");
	}
} // end of PrimeNumber