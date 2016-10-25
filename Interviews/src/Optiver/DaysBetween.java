package Optiver;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 7:25 AM.
 */
public class DaysBetween {
    /*
 * Complete the function below.
 */
    static int[] daysInMonth = {31,28,31,30,31,30,31, 31, 30, 31, 30, 31};
    static int DaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) throws Exception {
        return getDaysSinceBC(year2, month2, day2) - getDaysSinceBC(year1, month1, day1);
    }
    static int DaysBetween2(int year1, int month1, int day1, int year2, int
            month2, int day2) throws Exception {
        int days = (year2-year1)*365 + (year2 - year1)/4;
        return days;
    }

    static int getDaysSinceBC(int year, int month, int day) throws Exception {
        int daysSince = year*365 + day;
        for (int i= 0 ; i < month-1; i++)
            daysSince += daysInMonth[i];

        daysSince += leapDaysSinceBC (year, month);
        System.out.println(day + "/" + month + "/" + year +":" + daysSince);
        return daysSince;
    }
    static int leapDaysSinceBC(int year, int month)
    {
        int leap = (month > 2)? (year/4 - year/100 + year/400): (year-1 -
                (year-1)/100 + (year-1)/400);
        System.out.println(year + "/" +  month + leap);
        return leap;
    }

    // Do not edit below this line. It is only shown so you can see the function signature.
    // The implementation of the function is hidden.
//    static int DaysInMonth(int month, int year) throws Exception {
//
//    }
    public static void main(String[] args) {
        try {
            System.out.println(DaysBetween(2011, 1, 5, 2011, 12, 5));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
