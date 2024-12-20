public class Task {
    
    // instance variables
    private String label;
    private Date date;

    // constructor will always have a label for the task, optional to have a date object
    public Task (String label) { 
        this.label = label;
        date = new Date (-1, -1, -1);
    }
    public Task (String label, Date date) {
        this.label = label;
        this.date = date;
    }

    // toString for the tasks
    public String toString () { 
        return label + " | " + date.toString();
    }

}
