package problem17;

/*
Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) 
contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
*/

public class numberLetterCounts{
	public static void main(String[] args){
		int[] list = new int[1001];
		for(int i = 1; i < 10; i++){
			if(i == 1 || i == 2 || i == 6){ // one, two, six have three letters
				list[i] = 3;
			} else if(i == 4 || i == 5 || i == 9){ // four, five, nine have four letters
				list[i] = 4;
			} else{ // seven has five letters
				list[i] = 5;	
			}
		}
		for(int i = 11; i < 20; i++){
			if(i == 11 || i == 12){ // eleven and twelve have six letters
				list[i] = 6;
			} else if(i==15 || i == 16){ // fifteen and sixteen have seven letters
				list[i] = 7;
			} else if(i==13 || i == 14 || i == 18 || i == 19){ // thirteen, fourteen, eighteen, nineteen have eight letters
				list[i] = 8;
			} else { // seventeen has nine letters
				list[i] = 9;
			}
		}
		for(int i = 10; i < 100; i +=10){
			if(i == 10){ // ten has three letters
				list[i] = 3;
			} else if(i == 40 || i == 50 || i == 60){ // forty, fifty, sixty have five letters
				list[i] = 5;
			} else if(i == 30 || i == 20 || i == 80 || i == 90){ // thirty, twenty, eighty, ninety have six letters
				list[i] = 6;
			} else { // seventy has seven letters
				list[i] = 7;
			}
		}
		for(int i = 20; i < 100; i++){
			list[i] += list[i % 10]; // adding the "one's" digit counts to numbers between 20 and 99 that end in 1-9
			if(i % 10 != 0){
				list[i] += list[i - (i%10)]; // adding twenty, thirty, forty, etc to all numbers that end in 1-9
			}
		}
		for(int i = 100; i < 1000; i++){
			if(i % 100 != 0){
				list[i] += 10 + list[i/100] + list[i%100]; // [] + hundred and + []
			} else {
				list[i] += 7 + list[i/100]; // [] + hundred
			}
		}
		list[1000] = 11; // one thousand has eleven letters
		int sum = 0;
		for(int i = 0; i < 1001; i++){
			sum += list[i];
		}
		System.out.print(sum);
	}
}