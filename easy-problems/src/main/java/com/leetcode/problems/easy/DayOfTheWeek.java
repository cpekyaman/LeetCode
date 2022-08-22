package com.leetcode.problems.easy;

public class DayOfTheWeek {
    private static final int[] daysOfMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // the week days are ordered according to our starting day.
    // which is the current day or some date you already know.
    private static final String[] dayOfWeek = new String[] {
            "Saturday", "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday"
    };

    public String dayOfTheWeek(int day, int month, int year) {
        int now = daysSinceBegin(2, 7, 2022);
        int wanted = daysSinceBegin(day, month, year);

        // since day of week repeats every 7 days, numDaysBetween % 7 gives the week day at wanted date.
        // the trick below is to account for wanted > now.
        return dayOfWeek[(((wanted-now) % 7) + 7) % 7];
    }

    private int daysSinceBegin(int day, int month, int year) {
        int days = 0;
        // add days for each year (account for leap years)
        for(int i=1971; i<year; i++) {
            days += 365;
            if(isLeap(i)) {
                days++;
            }
        }

        // add days in months of wanted year until wanted month
        for(int i=1; i<month; i++) {
            days += daysOfMonth[i-1];
            if(i == 2 && isLeap(year)) {
                days++;
            }
        }

        // add days in wanted month (-1 is due to having 0 based array)
        days += day-1;
        return days;
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
