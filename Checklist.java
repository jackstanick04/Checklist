import java.util.ArrayList;

public class Checklist {
    
    // instance variables
    private ArrayList <Task> tasks;
    private boolean isComplete;

    // constructor methods (one that takes in a list and the other with an empty checklist)
    public Checklist () {
        tasks = new ArrayList <Task> ();
        isComplete = false;
    }
    public Checklist (ArrayList <Task> tasks) {
        this.tasks = tasks;
        isComplete = false;
    }
    
    // add method
    public void addTask (Task task) { 
        tasks.add(task);
    }

    // remove method (overloaded to be able to have an index)
    public void removeTask () {
        tasks.remove(tasks.size() - 1);
    }
    public void removeTask (int number) {
        // need to subtract one as the index will be 1 less than where it appears on the list
        tasks.remove(number - 1);
    }

    // toString method
    public String toString () {
        String result = "";
        // loop through and concatenate each task's toString on its own line
        for (Task task : tasks) {
            result += task.toString() + "\n";
        }
        return result;
    }

    // cleanList method which will remove all items that have been completed already
    public void cleanList () {
        // loop backward (to avoid index errors) and .remove any index where isDone is true
        for(int index = tasks.size() - 1; index > -1; index --) {
            if (tasks.get(index).getDone()) { 
                tasks.remove(index);
            }
        }
    }


}
