public class Date {
    
    // instance variables for the date
    private int month;
    private int day;
    private int year;

    // date constructor (no default is needed)
    public Date (int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    // toString method for printing
    public String toString () {
        return month + "/" + day + "/" + year;
    }

}
