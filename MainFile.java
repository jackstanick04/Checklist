import java.util.ArrayList;

public class MainFile { 

    public static void main (String [] args) { 

        Date myDate = new Date (12, 20, 2024);
        Task myTask = new Task ("Get food", myDate);
        myTask.changeStatus(true);
        Checklist myChecklist = new Checklist ();
        myChecklist.addTask (myTask);
        myChecklist.addTask (new Task ("Code project", new Date (12, 23, 2024)));
        System.out.println(myChecklist);
        myChecklist.cleanList();
        System.out.println(myChecklist);


    }

}