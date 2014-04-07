package problem18;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 By traversing a given triangle, find the largest sum of digits from top to bottom
 */

public class MaximumPathSum {
   
   public static int[][] triangle;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner fileScanner;
      int triangleSize;

      if (args.length == 0) {
         Scanner inputScanner = new Scanner(System.in);
         System.out.print("Enter the file of the triangle: ");
         fileScanner = new Scanner(new File(inputScanner.nextLine()));
         System.out.print("Enter the size of the triangle (number of rows): ");
         triangleSize = inputScanner.nextInt();
      } else {
         fileScanner = new Scanner(new File(args[0]));
         triangleSize = Integer.parseInt(args[1]);
      }

      // parsing the triangle into a 2D array
      triangle = new int[triangleSize][triangleSize];
      int row = 0;
      while (fileScanner.hasNextLine()) {
         Scanner lineScanner = new Scanner(fileScanner.nextLine());
         int col = 0;
         while (lineScanner.hasNextInt()) {
            triangle[row][col] = lineScanner.nextInt();
            col++;
         }
         row++;
      }
      
      // calculating the sum from bottom up
      for (int i = triangleSize - 2; i >= 0; i--) {
         for (int j = 0; j < i + 1; j++) {
            int left = triangle[i + 1][j];
            int right = triangle[i + 1][j + 1];
            triangle[i][j] += (left > right) ? left : right;
         }
      }
      System.out.println(triangle[0][0]);
   }
}
