package problem39;

/*
 Integer right triangles
 Problem 39
 If p is the perimeter of a right angle triangle with integral length sides,
 {a,b,c}, there are exactly three solutions for p = 120.

 {20,48,52}, {24,45,51}, {30,40,50}

 For which value of p <= 1000, is the number of solutions 
 maximised?
 */

public class IntRightTriangles {

    
   public static void main(String[] args) {
      String s = "";
      for (int i = 0; i <= 1000; i++) {
         s += i;
      }
      System.out.println(s.charAt(30));
   }
}
