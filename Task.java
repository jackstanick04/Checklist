public class Task {
    
    // instance variables
    private String label;
    private Date date;
    private Boolean isDone;

    // constructor will always have a label for the task, optional to have a date object
    public Task (String label) { 
        this.label = label;
        date = new Date();
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
        if (isDone && date.compareTo()) { 
            // using string.format to have it in a table-like approach (the first argument is custom escape sequences)
            return String.format("%-15s %-13s %-6s", label, date.toString(), "[X]");
        }
        else if (isDone && !date.compareTo()){
            return String.format("%-15s %-13s %-6s %-30s", label, date.toString(), "[X]", "Overtime and Overdue");
        }
        else if (!isDone && date.compareTo()) {
            return String.format("%-15s %-13s %-6s", label, date.toString(), "[O]");
        }
        else {
            return String.format("%-15s %-13s %-6s %-30s", label, date.toString(), "[O]", "Overtime and Overdue");
        }
    }

    // changes completion status (true is done)
    public void changeStatus (boolean newStatus) {
        isDone = newStatus;
    }

}
