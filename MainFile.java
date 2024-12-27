import java.util.Scanner;
import java.util.ArrayList;

public class MainFile { 

    // scanner and checklist list instanciation, static so they can be accessed in all methods
    private static Scanner reader = new Scanner(System.in);
    private static ArrayList <Checklist> lists = new ArrayList <Checklist> ();

    public static void main (String [] args) { 

        // using an int switch for the different choices (5 will be when they are done)
        int choice = 0;
        while (choice != 5) {

            // select general function
            System.out.println("Please choose the integer that corresponds to what you want to do: ");
            System.out.println("1) Create new list.");
            System.out.println("2) View my lists.");
            System.out.println("3) Edit a list.");
            System.out.println("4) Delete a list.");
            System.out.println("5) I am done with this program.");

            // will use scanner to take in the input and a dummy read
            System.out.println("Please enter your selection: ");
            choice = reader.nextInt();
            reader.nextLine();
            // formatting
            System.out.println();

            // now run a switch on choice, calling the respective static methods
            switch (choice) {   
                case 1: 
                    createNew();
                    break;
                case 2:
                    viewList();
                    break;
                case 3: 
                    editList();
                    break;
                case 4:
                    deleteList();
                    break;
                case 5:  
                    break;
                default : System.out.println("Please enter valid input.");
            }

        }
        
        System.out.println("The program is over.");

    }

    public static void createNew () {

        // take in name for the list
        String name = "";
        System.out.println("Please enter your name for the list: ");
        name = reader.nextLine();

        // check if they want to make an empty list or enter some items in at the beginning 
        System.out.println("Making new list. Enter 1 for empty list and 2 if you would like to put some items in originally.");
        int choice = reader.nextInt();
        reader.nextLine();

        if (choice == 1) {
            lists.add(new Checklist(name));
        }

        else {

            // make an a checklist (which will be added) and while loop to add tasks to it and then finally append to lists
            ArrayList <Task> itemList = new ArrayList <Task> ();
            String keepGoing = "";

            while (!keepGoing.equals("done")) {

                System.out.println("Please enter your description for your task: ");
                String description = reader.nextLine();
                System.out.println("Please enter your date in MM/DD/YYYY (press enter to automatically do today): ");
                String date = reader.nextLine();

                // check for if date is today
                if (date.equals("")) {
                    itemList.add(new Task (description, new Date()));
                }
                else {
                    itemList.add(new Task (description, new Date(date)));
                }

                System.out.println("Type \"done\" to finish adding items (otherwise just press enter).");
                keepGoing = reader.nextLine();

            }
            lists.add(new Checklist (name, itemList));
        }
        // formatting
        System.out.println();
    }

    public static void viewList () {
        
        // ask which list they would like to view (one more than index), have -1 be all 
        System.out.println("What list would you like to view (enter -1 for all)?");
        int choice = reader.nextInt();
        reader.nextLine();
        // formatting
        System.out.println();

        if (choice == -1) {
            // loop through and print all 
            for (int index = 0; index < lists.size(); index ++) {
                System.out.println(lists.get(index));
            }
        }
        else {
            System.out.println(lists.get(choice - 1));
        }

    }

    public static void editList() {

        // loop until the user is done editing
        String choice = "";
        while (!choice.equals("done")) {

            // ask what list the user wants to edit (will be one more than index) 
            System.out.println("What list would you like to edit?");
            int numList = reader.nextInt();

            // switch statement on which edit will be made to list
            System.out.println("Which edit would you like to make?");
            System.out.println("1) Add an item.");
            System.out.println("2) Remove an item.");
            System.out.println("3) Complete an item.");
            System.out.println("4) Clean list.");
            System.out.println("5) Check list completion.");
            int numChoice = reader.nextInt();
            reader.nextLine();
            // formatting
            System.out.println();

            switch (numChoice) {

                case 1: 
                    addItem(lists.get(numList - 1));
                    break;
                case 2: 
                    // to remove item, take in the number of the item to remove
                    System.out.println("Please enter the number of the item that you want to remove: ");
                    int numRem = reader.nextInt();
                    reader.nextLine();
                    lists.get(numList - 1).removeTask(numRem);
                    break;
                case 3: 
                    // to complete an item, once again takes a number
                    System.out.println("Please enter the number of the item that you want to complete: ");
                    int numComp = reader.nextInt();
                    reader.nextLine();
                    lists.get(numList - 1).completeTask(numComp);
                    break;
                case 4: 
                    // to clean the list just call the clean list method
                    lists.get(numList - 1).cleanList();
                    break;
                case 5:
                    // just call method to check if all done and if so, print that, otherwise print not
                    if (lists.get(numList - 1).allDone()) {
                        System.out.println("Your list has all been completed.");
                    }
                    else {
                        System.out.println("Your list still has items to be completed. Consider cleaning it?");
                    }
                    break;
                default:
                    System.out.println("Please enter valid input.");
            }

            // check if done editing
            System.out.println("Please type \" done \" if you are done editing.");
            choice = reader.nextLine();
            // formatting
            System.out.println();

        }

    }

    // add item method just to keep switch clean 
    public static void addItem (Checklist list1) {

        System.out.println("Please enter your description: ");
        String description = reader.nextLine();
        System.out.println("Please enter your date in MM/DD/YYYY: ");
        String date = reader.nextLine();

        // check for if date is today
        if (date.equals("")) {
            list1.addTask(new Task (description, new Date()));
        }
        else {
            list1.addTask(new Task (description, new Date(date)));
        }

    }

    // delete list method
    public static void deleteList () {

        // take in which list to remove (index will be one less and remove from lists)
        System.out.println("Which list would you like to remove?");
        int remove = reader.nextInt();
        lists.remove(remove - 1);

    }

}