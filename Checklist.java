import java.util.ArrayList;

public class Checklist {
    
    // instance variables
    private ArrayList <Task> tasks;
    private boolean isComplete;
    private String name;

    // constructor methods (one that takes in a list and the other with an empty checklist)
    public Checklist (String name) {
        tasks = new ArrayList <Task> ();
        isComplete = false;
        this.name = name;
    }
    
    // will not be actually used until later
    public Checklist (String name, ArrayList <Task> tasks) {
        this.tasks = tasks;
        isComplete = false;
        this.name = name;
    }
    
    // add method
    public void addTask (Task task) { 
        tasks.add(task);
    }

    // remove task
    public void removeTask (int number) {
        // need to subtract one as the index will be 1 less than where it appears on the list
        tasks.remove(number - 1);
    }

    // complete task method
    public void completeTask (int number) {
        // change completion status of index which is one prior to the number
        tasks.get(number - 1).changeStatus(true);
    }

    // toString method
    public String toString () {
        // start with the name
        String result = name + "\n";
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

    // method to check if all tasks are done
    public boolean allDone () {
        // loop through all the elements and if any are not done return false
        for (Task task : tasks) {
            if (!task.getDone()) {
                return false;
            }
        }
        return true;
    }


}
