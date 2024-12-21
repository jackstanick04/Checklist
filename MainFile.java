import java.util.ArrayList;
import java.util.Scanner;

public class MainFile { 

    public static void main (String [] args) { 

        runProgram();

    }

    // method to "run" the program
    public static void runProgram () {

        Scanner reader = new Scanner(System.in);

        // using an int switch for the different choices (7 will be when they are done)
        int choice = 0;
        while (choice != 7) {

            System.out.println("Please choose the integer that corresponds to what you want to do: ");
            System.out.println("1) Create a list (you can only have one right now).");
            System.out.println("2) Add an item to the list.");
            System.out.println("3) Remove an item from the list.");
            System.out.println("4) Complete/Incomplete an item on the list.");
            System.out.println("5) Clean list.");
            System.out.println("6) Check if done with all items.");
            System.out.println("7) I am done with this program.");
            // will use scanner to take in the input and a dummy read
            System.out.println("Please enter your selection: ");
            choice = reader.nextInt();
            reader.nextLine();

            // now run a switch on choice, calling every respective static method
            switch (choice) {
                case 1: createList(); break;
            }


        }

    }

    // where methods for each case will go (ex. createList())



}