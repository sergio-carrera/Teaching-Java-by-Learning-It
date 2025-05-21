import java.util.*;

public class BudgetTracker {
    private Scanner sc = new Scanner(System.in);
    private Map<Integer, Integer> yearToIndexMap = new HashMap<>();
    private Map<Integer, Integer> monthToIndexMap = new HashMap<>();
    private MonthlyCalculation[][] dataBase;

    /*
    Me gustaría tomar en cuenta solo 5 años (2020 - 2024):
           ____________________________________________________
    2020 - | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
    2021 - | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
    2022 - | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
    2023 - | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
    2024 - | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
           ----------------------------------------------------
    */

    public BudgetTracker () {
        yearToIndexMap.put(2020, 0);
        yearToIndexMap.put(2021, 1);
        yearToIndexMap.put(2022, 2);
        yearToIndexMap.put(2023, 3);
        yearToIndexMap.put(2024, 4);
        monthToIndexMap.put(1, 0);
        monthToIndexMap.put(2, 1);
        monthToIndexMap.put(3, 2);
        monthToIndexMap.put(4, 3);
        monthToIndexMap.put(5, 4);
        monthToIndexMap.put(6, 5);
        monthToIndexMap.put(7, 6);
        monthToIndexMap.put(8, 7);
        monthToIndexMap.put(9, 8);
        monthToIndexMap.put(10, 9);
        monthToIndexMap.put(11, 10);
        monthToIndexMap.put(12, 11);
        dataBase = new MonthlyCalculation[5][12];
    }

    public void calculate(int year, int month, double income, double rent, double groceries, double transportation, double entertainment) {
        try {
            if (revisarPorFormato(year, month, income, rent, groceries, transportation, entertainment)) {
                double totalExpenses = rent + groceries + transportation + entertainment;
                double remainingBudget = income - totalExpenses;
                double rentPercentage = (rent/totalExpenses) * 100;
                double groceriesPercentage = (groceries/totalExpenses) * 100;
                double transportationPercentage = (transportation/totalExpenses) * 100;
                double entertainmentPercentage = (entertainment/totalExpenses) * 100;
                MonthlyCalculation dato = new MonthlyCalculation(year, month, income, rent, groceries, transportation, entertainment, totalExpenses, remainingBudget, rentPercentage, groceriesPercentage, transportationPercentage, entertainmentPercentage);
                add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo de 'calculate': " + e);
        }
    }

    public void add(MonthlyCalculation registro) {
        try {
            if (revisarPorEspacio(registro)) {
                dataBase[yearToIndexMap.get(registro.getYear())][monthToIndexMap.get(registro.getMonth())] = registro;
                System.out.println("The next information has been calculated and added correctly to the database!");
                System.out.println(registro);
            } else {
                int opc = 0;
                do {
                    System.out.println("We have found an existing entry for this space in the data base.\n Would you like to replace it? \n1. Yes \n2. No");
                    System.out.println("Enter your response: ");
                    opc = sc.nextInt();
                    switch (opc) {
                        case 1:
                            dataBase[yearToIndexMap.get(registro.getYear())][monthToIndexMap.get(registro.getMonth())] = registro;
                            System.out.println("The record has been replaced with the following information: ");
                            System.out.println(registro);
                            break;
                        case 2:
                            System.out.println("The record hasn't been replaced");
                            break;
                        default:
                            System.out.println("Enter a valid response");
                            break;
                    }
                } while (opc != 2);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo de 'add': " + e);
        }
    }

    private boolean revisarPorEspacio(MonthlyCalculation registro) {
        try {
            return dataBase[yearToIndexMap.get(registro.getYear())][monthToIndexMap.get(registro.getMonth())] == null;
        } catch (Exception e) {
            System.out.println("Error el metodo de 'revisarPorEspacio': " + e);
            return false;
        }
    }

    private boolean revisarPorFormato(int year, int month, double income, double rent, double groceries, double transportation, double entertainment) {
        StringBuilder errors = new StringBuilder();
        Set<Integer> validYears = Set.of(2020, 2021, 2022, 2023, 2024);
        Set<Integer> validMonths = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        if (!validYears.contains(year)) {
            errors.append("The year has to be between 2020 and 2025\n");
        }
        if (!validMonths.contains(month)) {
            errors.append("The month has to be between 1 and 12\n");
        }
        if (!isValidDouble(income)) {
            errors.append("The income value has to be a number\n");
        }
        if (!isValidDouble(rent)) {
            errors.append("The rent value has to be a number\n");
        }
        if (!isValidDouble(groceries)) {
            errors.append("The groceries value has to be a number\n");
        }
        if (!isValidDouble(transportation)) {
            errors.append("The transportation value has to be a number\n");
        }
        if (!isValidDouble(entertainment)) {
            errors.append("The entertainment value has to be a number\n");
        }
        if (!errors.isEmpty()) {
            System.out.println("Format errors found:\n" + errors);
            return false;
        }
        return true;
    }

    private boolean isValidDouble(double value) {
        return !Double.isNaN(value) && !Double.isInfinite(value);
    }

    public void mostrar(int opc) {
        try {
            if (opc == 1) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (dataBase[i][j] != null) {
                            System.out.println(dataBase[i][j].toString());
                        } else {
                            System.out.println("There is no entry in here\n----------------------------");
                        }
                    }
                }
            } else if (opc == 2) {
                for (int i = 4; i >= 0; i--) {
                    for (int j = 11; j >= 0; j--) {
                        if (dataBase[i][j] != null) {
                            System.out.println(dataBase[i][j].toString());
                        } else {
                            System.out.println("There is no entry in here\n----------------------------");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error el metodo de 'mostrar': " + e);
        }
    }
}
