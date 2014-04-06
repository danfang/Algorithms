package problem19;

/*
 Counting Sundays
 Problem 19
 
 1 Jan 1900 was a Monday.
 Thirty days has September,
 April, June and November.
 All the rest have thirty-one,
 Saving February alone,
 Which has twenty-eight, rain or shine.
 And on leap years, twenty-nine.
 
 A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class CountingSundays {
   private static int day   = 7;   // first sunday
   private static int month = 1;
   private static int year  = 1900;

   public static void main(String[] args) {
      int sundayCount = 0;
      while (!(year >= 2000 && month == 12 && day == 31)) {
         day += 7;
         if (day > 27) {
            int monthType = getMonthType(month);
            if (rollOver(day, year, monthType)) {
               year = (month == 12) ? year + 1 : year; // if Dec, increment year
               month = (month == 12) ? 1 : month + 1;  // if Dec, reset month
               day = remainder(day, monthType);        // reset day
            }
         }
         if (day == 1 && year > 1900) {
            sundayCount++;
         }
      }
      System.out.println(sundayCount);
   }

   // month types:
   // 28/29 days (0)
   // 30 days (1)
   // 31 days (2)

   private static int remainder(int day, int monthType) {
      switch (monthType) {
         case 0:
            if ((year % 4 == 0 && year % 100 != 0) || year == 2000) { // leap
               return day - 29;
            }
            return day - 28;
         case 1:
            return day - 30;
         default:
            return day - 31;
      }
   }
   
   private static int getMonthType(int month) {
      if (month == 2) {
         return 0;
      } else if (month == 4 || month == 6 || month == 9 || month == 11) {
         return 1;
      }
      return 2;
   }

   private static boolean rollOver(int day, int year, int monthType) {
      switch (monthType) {
         case 0:
            if ((year % 4 == 0 && year % 100 != 0) || year == 2000) {
               return (day > 29) ? true : false;
            }
            return (day > 28) ? true : false;
         case 1:
            return (day > 30) ? true : false;
         default:
            return (day > 31) ? true : false;
      }
   }
}
