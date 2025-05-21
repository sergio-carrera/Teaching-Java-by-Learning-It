import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        BudgetTracker dataBase = new BudgetTracker();

        do {
            System.out.println("Bienvenido al Budget Tracker Plus");
            System.out.println("1. Add a new entry");
            System.out.println("2. Update an existing entry");
            System.out.println("3. Print entries of a specified year");
            System.out.println("4. Print entries of a specified month");
            System.out.println("5. Print an entry of a specified year and month");
            System.out.println("6. Print all entries sorted by year and month");
            System.out.println("7. Close the program");
            System.out.print("Enter an option: ");
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    System.out.print("Enter the year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter the month: ");
                    int month = sc.nextInt();
                    System.out.print("Enter your monthly income: ");
                    double income = sc.nextDouble();
                    System.out.print("Enter your monthly rent: ");
                    double rent = sc.nextDouble();
                    System.out.print("Enter your monthly groceries expense: ");
                    double groceries = sc.nextDouble();
                    System.out.print("Enter your monthly transportation expense: ");
                    double transportation = sc.nextDouble();
                    System.out.print("Enter your monthly entertainment expense: ");
                    double entertainment = sc.nextDouble();
                    dataBase.calculate(year, month, income, rent, groceries, transportation, entertainment);
                    break;
                case 2:
                    System.out.print("Enter the year of the entry you want to update: ");
                    int yearToUpdate = sc.nextInt();
                    System.out.print("Enter the month of the entry you want to update: ");
                    int monthToUpdate = sc.nextInt();
                    dataBase.updateMenu(yearToUpdate, monthToUpdate);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    int opc1 = 0;
                    do {
                        System.out.println("In which format would you like to print all entries?");
                        System.out.println("1. Normal");
                        System.out.println("2. Inverted");
                        System.out.println("3. Return to the main menu");
                        System.out.print("Enter the option: ");
                        opc1 = sc.nextInt();
                        dataBase.printAll(opc1);
                    } while (opc1 != 3);
                    break;
                case 7:
                    System.out.println("Closing the program...");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while (opc != 7);
    }
}