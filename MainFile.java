public class MainFile { 

    public static void main (String [] args) { 

        Date myDate = new Date (12, 20, 2024);
        Task myTask = new Task ("Get food", myDate);
        System.out.println(myTask);

    }

}