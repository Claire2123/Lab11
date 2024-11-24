import java.util.ArrayList;

public class Main {

    // Create a dynamic ArrayList of Strings
    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        boolean quit = false;

        while (!quit) {
            // Display the current list and menu options
            displayMenu();

            // Get user input using SafeInput (replace with your own method)
            String choice = SafeInput.getRegExString("Enter a command: ", "[AaDdIiPpQq]");

            switch (choice.toUpperCase()) {
                case "A":
                    addItem();
                    break;
                case "D":
                    deleteItem();
                    break;
                case "I":
                    insertItem();
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    quit = confirmQuit();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Displays the menu and list
    private static void displayMenu() {
        System.out.println("Current List:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i));
        }
        System.out.println("\nCommand Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    // Add an item to the list
    private static void addItem() {
        String item = SafeInput.getString("Enter the item to add: ");
        myArrList.add(item);
    }

    // Delete an item from the list
    private static void deleteItem() {
        printList();
        int itemToDelete = SafeInput.getRangedInt("Enter the item number to delete: ", 1, myArrList.size()) - 1;
        myArrList.remove(itemToDelete);
    }

    // Insert an item at a specific position
    private static void insertItem() {
        printList();
        int position = SafeInput.getRangedInt("Enter the position to insert (1-" + (myArrList.size() + 1) + "): ", 1, myArrList.size() + 1) - 1;
        String item = SafeInput.getString("Enter the item to insert: ");
        myArrList.add(position, item);
    }

    // Print the current list
    private static void printList() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ". " + myArrList.get(i));
        }
    }

    // Confirm quit
    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm("Are you sure you want to quit? (Y/N): ");
    }
}
