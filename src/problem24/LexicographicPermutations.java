package problem24;

import java.util.HashSet;
import java.util.Set;

import problem34.DigitFactorials;

/*
 Lexicographic permutations
 Problem 24
 A permutation is an ordered arrangement of objects. For example, 3124 is one
 possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 are listed numerically or alphabetically, we call it lexicographic order. 

 The lexicographic permutations of 0, 1 and 2 are:
 012   021   102   120   201   210

 What is the millionth lexicographic permutation of the digits 
 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class LexicographicPermutations {

   private static int permutationsFound = 0;
   
   public static void main(String[] args) {
      permuteTo("0123456789", "");
   }

   private static void permuteTo(String s, String chosen) {
      if (s.length() == 0) {
         permutationsFound++;
         if (permutationsFound == 1000000) {
            System.out.println(chosen);
         }
      } else if (permutationsFound <= 1000000) {
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1);
            permuteTo(rest, chosen + ch);
         }
      }
   }
}
