import java.util.Scanner;

public class MainFile { 

    public static void main (String [] args) { 

        // formatting 
        System.out.println();

        // scanner instanciation and checklist initialization
        Scanner reader = new Scanner(System.in);
        Checklist thisList = new Checklist ();
        System.out.println("You have an empty list.");

        // using an int switch for the different choices (6 will be when they are done)
        int choice = 0;
        while (choice != 6) {

            // formatting
            System.out.println();
            System.out.println("Your list is as follows.");
            System.out.println(thisList);

            System.out.println("Please choose the integer that corresponds to what you want to do: ");
            System.out.println("1) Add an item to the list.");
            System.out.println("2) Remove an item from the list.");
            System.out.println("3) Complete an item on the list.");
            System.out.println("4) Clean list.");
            System.out.println("5) Check if done with all items.");
            System.out.println("6) I am done with this program.");
            // will use scanner to take in the input and a dummy read
            System.out.println("Please enter your selection: ");
            choice = reader.nextInt();
            reader.nextLine();
            // formatting 
            System.out.println();

            // now run a switch on choice, calling every respective static method
            switch (choice) {
                case 1:
                    // to add an item, use the scanner to take in the date and description
                    System.out.println("Please enter your description: ");
                    String description = reader.nextLine();
                    System.out.println("Please enter your date in MM/DD/YYYY: ");
                    String date = reader.nextLine();
                    thisList.addTask(new Task (description, new Date(date)));
                    break;
                case 2: 
                    // to remove item, take in the number of the item to remove
                    System.out.println("Please enter the number of the item that you want to remove: ");
                    int numRem = reader.nextInt();
                    thisList.removeTask(numRem);
                    break;
                case 3: 
                    // to complete an item, once again takes a number
                    System.out.println("Please enter the number of the item that you want to complete: ");
                    int numComp = reader.nextInt();
                    thisList.completeTask(numComp);
                    break;
                case 4: 
                    // to clean the list just call the clean list method
                    thisList.cleanList();
                    break;
                case 5: 
                    // just call method to check if all done and if so, print that, otherwise print not
                    if (thisList.allDone()) {
                        System.out.println("Your list has all been completed.");
                    }
                    else {
                        System.out.println("Your list still has items to be completed. Consider cleaning it?");
                    }
                    break;
                case 6: 
                    // break out 
                    break;
                default : System.out.println("Please enter valid input.");
            }

        }
        
        System.out.println("The program is over.");

    }

}