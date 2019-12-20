package com.example.calender;

public class Calender {
    /**
     * Data Field
     */
    private int month;
    private int year;

    /**
     * Constructors
     */
    public Calender(int year, int month) throws IllegalArgumentException {
        if (!checkYear(year))
            throw new IllegalArgumentException("Illegal Year, must be less than 1800");
        this.year = year;

        if (!checkMonth(month))
            throw new IllegalArgumentException("Illegal Month");
        this.month = month;
    }

    /**
     * Default Constructors
     */
    public Calender() {
        this(java.util.Calendar.YEAR, java.util.Calendar.MONTH);
    }

    /**
     * @return month
     */
    public int getMonth() {
        return month;
    }

    /**
     * set month
     */
    public void setMonth(int month) throws IllegalArgumentException {
        if (!checkMonth(month))
            throw new IllegalArgumentException("Illegal Month");
        this.month = month;
    }

    /**
     * @return year
     */
    public int getYear() {
        return year;
    }

    /**
     * set year
     */
    public void setYear(int year) throws IllegalArgumentException {
        if (!checkYear(year))
            throw new IllegalArgumentException("Illegal Year, must be less than 1800");
        this.year = year;
    }

    /**
     * Get the English name for the month
     */
    public String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }

    public int[][] ArrayMonthBody() {
        return ArrayMonthBody(getYear(), getMonth());
    }

    public int[][] ArrayMonthBody(int year, int month) {
        int[][] monthBody = new int[6][7];
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        int j = 0;
        int k = startDay;
        for (int i = 1; i <= numberOfDaysInMonth; i++) {

            monthBody[j % 6][k % 7] = i;
            k++;
            if ((i + startDay) % 7 == 0) {
                k = 0;
                j++;
            }
        }
        return monthBody;
    }

    /**
     * Print the calendar for a month in a year
     */
    public void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    /**
     * Print the month title, e.g., March 2019
     */
    private void printMonthTitle(int year, int month) {
        System.out.println("          " + getMonthName(month) + " " + year);
        System.out.println(" −−−−−−−−−−−−−−−−−−−−-------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /**
     * Print month body
     */
    private void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
        int i = 0;

        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);

            if ((i + startDay) % 7 == 0)
                System.out.println();
        }

        System.out.println();
    }

    /**
     * Get the start day of month/1/year
     */
    public int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;
        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /**
     * Get the total number of days since January 1, 1800
     */
    public int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;

        // Add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);

        return total;
    }

    /**
     * Get the number of days in a month
     */
    public int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isLeapYear(year) ? 29 : 28;
        return 0; // If month is incorrect
    }

    /**
     * Determine if it is a leap year
     */
    public boolean isLeapYear(int year) {
        /** Determine if it is a leap year */
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * Determine if the Month is correct
     */
    private boolean checkMonth(int month) {
        if (month < 1 || month > 12)
            return false;
        else
            return true;
    }

    /**
     * Determine if the Year is correct
     */
    private boolean checkYear(int year) {
        if (year < 1800)
            return false;
        else
            return true;
    }
}
