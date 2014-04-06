package problem12;

/*
Highly divisible triangular number
Problem 12
The sequence of triangle numbers is generated by adding the natural numbers. So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

 1: 1
 3: 1,3
 6: 1,2,3,6
10: 1,2,5,10
15: 1,3,5,15
21: 1,3,7,21
28: 1,2,4,7,14,28
We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
*/
public class triangleNumber{
	public static void main(String[] args){
		int divisorCount  = 0, triangleCount = 1, testTriangle = 0;
		while(divisorCount < 501){
			divisorCount = 0;
			testTriangle = generateTriangle(triangleCount);
			for(int i = 1; i * i <= testTriangle; i++){
				if(testTriangle % i == 0){
					divisorCount+= 2;
				}
			}
			triangleCount++;
		}
		System.out.print(testTriangle);
	}
	public static int generateTriangle(int number){
		int sum = 0;
		for(int i = 1; i <= number; i++){
			sum+=i;
		}
		return sum;
	}
}	