import java.util.Scanner;

public class SafeInput {

    private static Scanner sc = new Scanner(System.in);

    public static String getRegExString(String prompt, String regex) {
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine();
            if (!input.matches(regex)) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!input.matches(regex));
        return input;
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static int getRangedInt(String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                sc.next();  // discard invalid input
                System.out.print("Invalid input. Try again: ");
            }
            input = sc.nextInt();
        } while (input < min || input > max);
        return input;
    }

    public static boolean getYNConfirm(String prompt) {
        String response = getRegExString(prompt, "[YyNn]");
        return response.equalsIgnoreCase("Y");
    }
}

