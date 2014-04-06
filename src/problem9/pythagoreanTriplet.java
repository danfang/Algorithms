package problem9;

/*
Special Pythagorean triplet
Problem 9
A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
*/

public class pythagoreanTriplet {
   public static void main(String[] args) {
      int a = 0, b = 0, c = 0;
      while (a + b + c != 1000) {
         for (int cSquared = 1; cSquared <= 1000000; cSquared++) {
            if (Math.sqrt((double) cSquared) % 1 == 0.0) {
               c = (int) Math.sqrt(cSquared); // finds cSquared for all c up to 1000
               for (int j = 1; j < c; j++) {
                  for (int k = 1; k < j; k++) {
                     if ((j * j) + (k * k) == cSquared) {
                        a = j;
                        b = k;
                        if (a + b + c == 1000) {
                           System.out.println(a + " " + b + " " + c);
                           System.out.println(a * b * c);
                           k = j;
                           j = c;
                           cSquared = 1000001;
                        }
                     }
                  }
               }
            }
         }
      } // end of while
   } // end of main method
} // end of pythagoreanTriplet