package problem15;

/*
 Lattice paths
 Problem 15
 Starting in the top left corner of a 2×2 grid, and only being able to move to the right
 and down, there are exactly 6 routes to the bottom right corner.
 How many such routes are there through a 20×20 grid?
 */

public class LatticePaths {
   
   public static final int GRID_LIMIT = 40;
   public static long[][] cache;

   public static void main(String[] args) {
      cache = new long[GRID_LIMIT + 1][GRID_LIMIT + 1];
      System.out.println(findPaths(0, 0));
   }
   
   private static long findPaths(int posX, int posY) {
      if (posX == GRID_LIMIT && posY == GRID_LIMIT) {
         return 1; // new path found
      }
      if (posX <= GRID_LIMIT && posY <= GRID_LIMIT) {
         if (cache[posX][posY] != 0) {
            return cache[posX][posY]; // cached result
         } else { // recursive backtracking
            long paths = findPaths(posX + 1, posY) + findPaths(posX, posY + 1);
            cache[posX][posY] = paths;
            return paths;
         }
      }
      return 0;
   }
}
