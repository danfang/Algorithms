package problem43;

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
