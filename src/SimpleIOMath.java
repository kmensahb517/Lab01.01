import java.util.Scanner;

/**
 * Ask the user questions and then will print out the user entry plus do a few extra calculations and computations with the user's data
 * @version 09.17.2025
 * author 26mensahb
 * Flint session here:
 */

public class SimpleIOMath {
    private String name;
    private int age;
    private int favNumber;

    /**
     * Asks the user questions using Scanner
     */
    public void promptUser() {
        Scanner in = new Scanner(System.in);
        System.out.print("Question 1: What is your name? ");
        name = in.nextLine();
        while (true) {
            try {
                System.out.print("Question 2: How old are you? ");
                String input = in.nextLine().trim();

                // keep only digits
                input = input.replaceAll("[^0-9]", "");

                if (input.isEmpty()) {
                    System.out.println("Invalid input, please enter a valid number.");
                    continue;
                }

                int parsedAge = Integer.parseInt(input);

                if (parsedAge < 0) {
                    System.out.println("Invalid input, age cannot be negative.");
                    continue;
                }

                if (parsedAge > 123) {
                    System.out.println("No human has ever lived longer than 122 years!");
                    continue;
                }

                age = parsedAge;
                break;

            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }

        while (true) {
            try {
                System.out.print("Question 3: What is your favorite number? ");
                String input = in.nextLine().trim();

                input = input.replaceAll("[^0-9]", "");

                if (input.isEmpty()) {
                    System.out.println("Invalid input, please enter a valid number.");
                    continue;
                }

                favNumber = Integer.parseInt(input);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a valid number.");
            }
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
               }
        }
        return true;
    }

    private int firstPrimeFactor() {
        for (int i = 2; i <= Math.sqrt(age); i++) {
            if (isPrime(i) && age % i == 0) {
                return i;
            }
        }
        return age;
    }

    /**
     * Summarize the conversation
     */
    public void printInfo() {
        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);
        System.out.println("At your next birthday, you will turn " + (age + 1) + ".");
        System.out.println("The first prime factor of " + age + " is " + firstPrimeFactor());
        System.out.println("Your favorite number squared is: " + (int) (Math.pow(favNumber, 2)));
    }

    /**
     * Main method for class SimpleIOMath
     * @param args command line arguments, if needed
     */
    public static void main(String[] args) {
        SimpleIOMath app = new SimpleIOMath();
        System.out.println(" * Sit yourself down, take a seat *");
        System.out.println("* All you gotta do is repeat after me *");
        app.promptUser();
        app.printInfo();
        System.out.println("* end of program *");
    }
}
