public class Task {
    
    // instance variables
    private String label;
    private Date date;
    private Boolean isDone;

    // constructor will always have a label for the task, optional to have a date object
    public Task (String label) { 
        this.label = label;
        date = new Date (-1, -1, -1);
        isDone = false;
    }
    public Task (String label, Date date) {
        this.label = label;
        this.date = date;
        isDone = false;
    }

    // isDone getter
    public boolean getDone () {
        return isDone;
    }

    // toString for the tasks, depends on if it is complete or not for the O or X, use tabs for table-look
    public String toString () { 
        if (isDone) { 
            // using string.format to have it in a table-like approach (the first argument is custom escape sequences)
            return String.format("%-15s %-13s %-3s", label, date.toString(), "[X]");
        }
        return String.format("%-15s %-13s %-3s", label, date.toString(), "[O]");
    }

    // changes completion status
    public void changeStatus (boolean newStatus) {
        isDone = newStatus;
    }

}
