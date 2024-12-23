// for the current date
import java.time.LocalDate;

public class Date {
    
    // instance variables for the date
    private int month;
    private int day;
    private int year;

    // default date will be the current date
    public Date () {
        // current date object
        LocalDate today = LocalDate.now();
        month = today.getMonthValue();
        day = today.getDayOfMonth();
        year = today.getYear();
    }

    // date constructor (no default is needed)
    public Date (String date) {
        // split and parse the elements to ints to then be stored
        String [] strArr = date.split("/");
        int [] intArr = new int [3];
        for (int index = 0; index < 3; index ++) {
            intArr [index] = Integer.parseInt(strArr [index]);
        }
        month = intArr [0];
        day = intArr [1];
        year = intArr [2];
    }

    // toString method for printing
    public String toString () {
        return month + "/" + day + "/" + year;
    }

    // getter methods for all 3 parts of the date
    public int getDay () {
        return day;
    }
    public int getMonth () {
        return month;
    }
    public int getYear () {
        return year;
    }

    // setter method which just updates the entire new date at once
    public void setDate (int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // compareTo method which will see if the given date is before or equal to the current date
    public boolean compareTo () {

        // instanciate current date object as date2, the if statements use the needed getters
        LocalDate date2 = LocalDate.now();

        // goes year, month, day to work efficiently
        if (year < date2.getYear()) {
            return false;
        }
        else if (year == date2.getYear()) {
            if (month < date2.getMonthValue()) {
                return false;
            }
            else if (month == date2.getMonthValue()) {
                if (day < date2.getDayOfMonth()) {
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;

    }

}
