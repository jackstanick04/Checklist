public class Date {
    
    // instance variables for the date
    private int month;
    private int day;
    private int year;

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

    // compareTo method which will see if the given date is before or equal to the new, entered date (parameter)
    public boolean compareTo (Date date2) {
        // goes year, month, day to work efficiently
        if (year < date2.getYear()) {
            return true;
        }
        else if (year == date2.getYear()) {
            if (month < date2.getMonth()) {
                return true;
            }
            else if (month == date2.getMonth()) {
                if (day <= date2.getDay()) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

}
