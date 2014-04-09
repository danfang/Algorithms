package problem35;
import java.util.LinkedList;
import java.util.List;


public class SieveEratosthenes {
   
   public static void main(String[] args) {
      List<Integer> l = getPrimeArray(120);
      System.out.println(l);
   }
   
   public static List<Integer> getPrimeArray(int limit) {
      boolean[] sieve = new boolean[limit + 1];
      List<Integer> primes = new LinkedList<Integer>();
      int p = 2;
      // marking non-primes as true so that the default is prime
      while (p * p <= limit) {
         sieve[p * p] = true;
         int multiple = p * p;
         while (multiple <= limit) {
            sieve[multiple] = true;
            multiple += p;
         }
         for (int i = p + 1; i <= limit; i++) {
            if (!sieve[i]) {
               p = i;
               break;
            }
         }
      }
      for (int i = 2; i <= limit; i++) {
         if (!sieve[i]) {
            primes.add(i);
         }
      }
      return primes;
   }

}
