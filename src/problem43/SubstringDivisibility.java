package problem43;

/*
 Sub-string divisibility
 Problem 43
 The number, 1406357289, is a 0 to 9 pandigital number because it is made
 up of each of the digits 0 to 9 in some order, but it also has a rather
 interesting sub-string divisibility property.

 Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way,
 we note the following:

 d2d3d4=406 is divisible by 2
 d3d4d5=063 is divisible by 3
 d4d5d6=635 is divisible by 5
 d5d6d7=357 is divisible by 7
 d6d7d8=572 is divisible by 11
 d7d8d9=728 is divisible by 13
 d8d9d10=289 is divisible by 17
 
 Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class SubstringDivisibility  {

   private static int[]     divisibility         = { 0, 2, 3, 5, 7, 11, 13, 17 };
   private static long      pandigitalSum        = 0;
   private static int       permutationsFound    = 0;

   private static final int MAXIMUM_PERMUTATIONS = 3628800; // 10!

   public static void main(String[] args) {
      permute("0123456789", "");
      System.out.println(pandigitalSum);
   }

   private static void permute(String s, String chosen) {
      if (s.length() == 0) {
         if (testPandigital(chosen)) {
            pandigitalSum += Long.parseLong(chosen);
         }
         permutationsFound++;
      } else if (permutationsFound <= MAXIMUM_PERMUTATIONS) {
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String rest = s.substring(0, i) + s.substring(i + 1);
            permute(rest, chosen + ch);
         }
      }
   }

   private static boolean testPandigital(String s) {
      boolean flag = true;
      for (int i = 1; i <= s.length() - 3; i++) {
         String sub = s.substring(i, i + 3);
         if (Double.valueOf(sub) % divisibility[i] != 0) {
            flag = false;
         }
      }
      return flag;
   }
}
