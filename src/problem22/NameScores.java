package problem22;

/*
 Names Scores
 Problem 22
 Using names.txt, a 46K text file containing over five-thousand first names,
 begin by sorting it into alphabetical order. Then working out the alphabetical
 value for each name, multiply this value by its alphabetical position in the list
 to obtain a name score.

 For example, when the list is sorted into alphabetical order, COLIN, which is worth
 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a 
 score of 938 × 53 = 49714.

 What is the total of all the name scores in the file?
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameScores {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner scan = new Scanner(new File("src/problem22/names.txt"));
      String names = scan.next();
      
      // using regex to split the text file into strings
      String[] nameArray = names.split("[\\W]+");
      
      // putting names into a map
      Map<String, Integer> scores = new TreeMap<String, Integer>();
      for (String s : nameArray) {
         int value = 0;
         for (int i = 0; i < s.length(); i++) {
            value += s.charAt(i) - 'A' + 1;
         }
         scores.put(s, value);
      }
      
      // calculating the score
      int multiplier = 0;
      int totalScore = 0;
      for (String key : scores.keySet()) {
         totalScore += scores.get(key) * multiplier;
         multiplier++;
      }
      System.out.println(totalScore);
   }
}
