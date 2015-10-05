package problem469;

public class EmptyChairs {

   private static final int N = 100000000;
   
  
   public static void main(String[] args) {
      int[] values = new int[4 * N + 4];
      values[1] = 1;
      values[3] = 3;
      for (int i = 1; i <= N; i++) {
         values[2 * i] = values[i];
         values[4 * i + 1] = 2 * values[2 * i + 1] - values[i];
         values[4 * i + 3] = 3 * values[2 * i + 1] - 2 * values[i];
      }
      
      int sum = 0;
      for (int i = 1; i <= N; i++) {
         sum += values[i];
      }
      System.out.println(sum);
   }

}
