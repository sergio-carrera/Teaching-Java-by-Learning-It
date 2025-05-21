import java.util.*;

public class BudgetTracker {
    final Scanner sc = new Scanner(System.in);
    final Map<Integer, Integer> yearToIndexMap = new HashMap<>();
    final Map<Integer, Integer> monthToIndexMap = new HashMap<>();
    private MonthlyCalculation[][] dataBase;
    final Set<Integer> validYears = Set.of(2020, 2021, 2022, 2023, 2024);
    final Set<Integer> validMonths = Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

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
                double rentPercentage = (rent / income) * 100;
                double groceriesPercentage = (groceries / income) * 100;
                double transportationPercentage = (transportation / income) * 100;
                double entertainmentPercentage = (entertainment / income) * 100;
                MonthlyCalculation dato = new MonthlyCalculation(year, month, income, rent, groceries, transportation, entertainment, totalExpenses, remainingBudget, rentPercentage, groceriesPercentage, transportationPercentage, entertainmentPercentage);
                add(dato);
            }
        } catch (Exception e) {
            System.out.println("Error in the 'calculate' method : " + e);
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
            System.out.println("Error in the 'add' method: " + e);
        }
    }

    private boolean revisarPorEspacio(MonthlyCalculation registro) {
        try {
            return dataBase[yearToIndexMap.get(registro.getYear())][monthToIndexMap.get(registro.getMonth())] == null;
        } catch (Exception e) {
            System.out.println("Error in the 'revisarPorEspacio' method: " + e);
            return false;
        }
    }

    private boolean revisarPorFormato(int year, int month, double income, double rent, double groceries, double transportation, double entertainment) {
        StringBuilder errors = new StringBuilder();
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

    public void updateMenu(int year, int month) {
        try {
            StringBuilder errors = new StringBuilder();
            if (!validYears.contains(year)) {
                errors.append("The year has to be between 2020 and 2025\n");
            }
            if (!validMonths.contains(month)) {
                errors.append("The month has to be between 1 and 12\n");
            }
            if (!errors.isEmpty()) {
                System.out.println("Format errors found:\n" + errors);
                return;
            }
            MonthlyCalculation datoToUpdate = dataBase[yearToIndexMap.get(year)][monthToIndexMap.get(month)];
            if (datoToUpdate != null) {
                int opc = 0;
                do {
                    System.out.println("\nHow would you like to update the entry?");
                    System.out.println("1. Update income expense");
                    System.out.println("2. Update rent expense");
                    System.out.println("3. Update groceries expense");
                    System.out.println("4. Update transportation expense");
                    System.out.println("5. Update entertainment expense");
                    System.out.println("6. Update all expenses");
                    System.out.println("7. Return to main menu");
                    System.out.print("Enter an option: ");
                    opc = sc.nextInt();
                    update(datoToUpdate, opc);
                } while (opc != 7);
            } else {
                System.out.println("There is no such entry to be updated");
            }

        } catch (Exception e) {
            System.out.println("Error in the 'updateMenu' method: " + e);
        }
    }

    private void update(MonthlyCalculation datoToUpdate, int opc) {
        try {
            switch (opc) {
                /*
                Probando la nueva sintaxis de switch...
                _____________________________________________________________________________________________
                | Característica           | `case 1:`              | `case 1 ->`                            |
                | ------------------------ | ---------------------- | -------------------------------------- |
                | Introducido en           | Desde siempre (Java 1) | Java 14+ (como preview, estable en 17) |
                | Necesita `break`         | Sí                     | No                                     |
                | Permite *fall through*   | Sí                     | No                                     |
                | Sintaxis                 | Imperativa             | Expresiva / Funcional                  |
                | Permite múltiples líneas | Sí                     | Sí, con bloque `{}`                    |
                | Más segura y legible     | No                     | Sí                                     |
                ----------------------------------------------------------------------------------------------
                */
                case 1 -> updateIncome(datoToUpdate);
                case 2 -> updateRent(datoToUpdate);
                case 3 -> updateGroceries(datoToUpdate);
                case 4 -> updateTransportation(datoToUpdate);
                case 5 -> updateEntertainment(datoToUpdate);
                case 6 -> updateAll(datoToUpdate);
                case 7 -> System.out.println("Returning to main menu");
                default -> System.out.println("Please enter a valid option");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void updateIncome(MonthlyCalculation datoToUpdate) {
        try {
            double newIncomeValue;
            System.out.println("Existing value: " + datoToUpdate.getIncome());
            System.out.print("New value: ");
            newIncomeValue = sc.nextDouble();
            double[] values = {newIncomeValue,
                    datoToUpdate.getRent(),
                    datoToUpdate.getGroceries(),
                    datoToUpdate.getTransportation(),
                    datoToUpdate.getEntertainment()
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setIncome(newIncomeValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The income and the respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateIncome' method: " + e);
        }
    }

    private void updateRent(MonthlyCalculation datoToUpdate) {
        try {
            double newRentValue;
            System.out.println("Existing value: " + datoToUpdate.getRent());
            System.out.print("New value: ");
            newRentValue = sc.nextDouble();
            double[] values = {datoToUpdate.getIncome(),
                    newRentValue,
                    datoToUpdate.getGroceries(),
                    datoToUpdate.getTransportation(),
                    datoToUpdate.getEntertainment()
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setRent(newRentValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The rent and the respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateRent' method: " + e);
        }
    }

    private void updateGroceries(MonthlyCalculation datoToUpdate) {
        try {
            double newGroceriesValue;
            System.out.println("Existing value: " + datoToUpdate.getGroceries());
            System.out.print("New value: ");
            newGroceriesValue = sc.nextDouble();
            double[] values = {datoToUpdate.getIncome(),
                    datoToUpdate.getRent(),
                    newGroceriesValue,
                    datoToUpdate.getTransportation(),
                    datoToUpdate.getEntertainment()
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setGroceries(newGroceriesValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The groceries and the respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateGroceries' method: " + e);
        }
    }

    private void updateTransportation(MonthlyCalculation datoToUpdate) {
        try {
            double newTransportationValue;
            System.out.println("Existing value: " + datoToUpdate.getTransportation());
            System.out.print("New value: ");
            newTransportationValue = sc.nextDouble();
            double[] values = {datoToUpdate.getIncome(),
                    datoToUpdate.getRent(),
                    datoToUpdate.getGroceries(),
                    newTransportationValue,
                    datoToUpdate.getEntertainment()
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setTransportation(newTransportationValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The transportation and the respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateTransportation' method: " + e);
        }
    }

    private void updateEntertainment(MonthlyCalculation datoToUpdate) {
        try {
            double newEntertainmentValue;
            System.out.println("Existing value: " + datoToUpdate.getEntertainment());
            System.out.print("New value: ");
            newEntertainmentValue = sc.nextDouble();
            double[] values = {datoToUpdate.getIncome(),
                    datoToUpdate.getRent(),
                    datoToUpdate.getGroceries(),
                    datoToUpdate.getTransportation(),
                    newEntertainmentValue
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setEntertainment(newEntertainmentValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The entertainment and the respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateEntertainment' method: " + e);
        }
    }

    private void updateAll(MonthlyCalculation datoToUpdate) {
        try {
            double newIncomeValue;
            double newRentValue;
            double newGroceriesValue;
            double newTransportationValue;
            double newEntertainmentValue;
            System.out.println("Existing value for income: " + datoToUpdate.getIncome());
            System.out.println("Existing value for rent expense: " + datoToUpdate.getRent());
            System.out.println("Existing value for groceries expense: " + datoToUpdate.getGroceries());
            System.out.println("Existing value for transportation expense: " + datoToUpdate.getTransportation());
            System.out.println("Existing value entertainment: " + datoToUpdate.getEntertainment());
            System.out.print("New value for income: ");
            newIncomeValue = sc.nextDouble();
            System.out.print("New value for rent: ");
            newRentValue = sc.nextDouble();
            System.out.print("New value for groceries: ");
            newGroceriesValue = sc.nextDouble();
            System.out.print("New value for transportation: ");
            newTransportationValue = sc.nextDouble();
            System.out.print("New value for entertainment: ");
            newEntertainmentValue = sc.nextDouble();
            double[] values = {newIncomeValue,
                    newRentValue,
                    newGroceriesValue,
                    newTransportationValue,
                    newEntertainmentValue
            };
            double[] newValues = calculateNewValues(values);
            datoToUpdate.setIncome(newIncomeValue);
            datoToUpdate.setRent(newRentValue);
            datoToUpdate.setGroceries(newGroceriesValue);
            datoToUpdate.setTransportation(newTransportationValue);
            datoToUpdate.setEntertainment(newEntertainmentValue);
            datoToUpdate.setTotalExpenses(newValues[0]);
            datoToUpdate.setRemainingBudget(newValues[1]);
            datoToUpdate.setRentPercentage(newValues[2]);
            datoToUpdate.setGroceriesPercentage(newValues[3]);
            datoToUpdate.setTransportationPercentage(newValues[4]);
            datoToUpdate.setEntertainmentPercentage(newValues[5]);
            System.out.println("The respective values have been updated");
        } catch (Exception e) {
            System.out.println("Error in 'updateAll' method: " + e);
        }
    }

    private double[] calculateNewValues(double[] values) {
        double totalExpenses = values[1] + values[2] + values[3] + values[4];
        double remainingBudget = values[0] - totalExpenses;
        double rentPercentage = (values[1] / values[0]) * 100;
        double groceriesPercentage = (values[2] / values[0]) * 100;
        double transportationPercentage = (values[3] / values[0]) * 100;
        double entertainmentPercentage = (values[4] / values[0]) * 100;

        return new double[]{totalExpenses, remainingBudget, rentPercentage, groceriesPercentage,
                transportationPercentage, entertainmentPercentage};
    }

    public void printByYear(int year, int opc) {
        try {
            StringBuilder errors = new StringBuilder();
            if (!validYears.contains(year)) {
                errors.append("The year has to be between 2020 and 2025\n");
            }
            if (!errors.isEmpty()) {
                System.out.println("Format errors found:\n" + errors);
                return;
            }
            if (opc == 1) {
                for (int j = 0; j < 12; j++) {
                    if (dataBase[yearToIndexMap.get(year)][j] != null) {
                        System.out.println(dataBase[yearToIndexMap.get(year)][j].toString());
                    } else {
                        System.out.println("There is no entry in here\n----------------------------");
                    }
                }
            } else if (opc == 2) {
                for (int j = 11; j >= 0; j--) {
                    if (dataBase[yearToIndexMap.get(year)][j] != null) {
                        System.out.println(dataBase[yearToIndexMap.get(year)][j].toString());
                    } else {
                        System.out.println("There is no entry in here\n----------------------------");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in 'printByYear' method: " + e);
        }
    }

    public void printByMonth(int month, int opc) {
        try {
            StringBuilder errors = new StringBuilder();
            if (!validMonths.contains(month)) {
                errors.append("The month has to be between 1 and 12\n");
            }
            if (!errors.isEmpty()) {
                System.out.println("Format errors found:\n" + errors);
                return;
            }
            if (opc == 1) {
                for (int i = 0; i < 5; i++) {
                    if (dataBase[i][monthToIndexMap.get(month)] != null) {
                        System.out.println(dataBase[i][monthToIndexMap.get(month)].toString());
                    } else {
                        System.out.println("There is no entry in here\n----------------------------");
                    }
                }
            } else if (opc == 2) {
                for (int i = 4; i >= 0; i--) {
                    if (dataBase[i][monthToIndexMap.get(month)] != null) {
                        System.out.println(dataBase[i][monthToIndexMap.get(month)].toString());
                    } else {
                        System.out.println("There is no entry in here\n----------------------------");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in 'printByMonth' method: " + e);
        }
    }

    public void printByYearAndMonth(int year, int month, int opc) {
        try {
            StringBuilder errors = new StringBuilder();
            if (!validYears.contains(year)) {
                errors.append("The year has to be between 2020 and 2025\n");
            }
            if (!validMonths.contains(month)) {
                errors.append("The month has to be between 1 and 12\n");
            }
            if (!errors.isEmpty()) {
                System.out.println("Format errors found:\n" + errors);
                return;
            }
            if (opc == 1) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 12; j++) {
                        if (dataBase[yearToIndexMap.get(year)][monthToIndexMap.get(month)] != null) {
                            System.out.println(dataBase[yearToIndexMap.get(year)][monthToIndexMap.get(month)].toString());
                        } else {
                            System.out.println("There is no entry in here\n----------------------------");
                        }
                    }
                }
            } else if (opc == 2) {
                for (int i = 4; i >= 0; i--) {
                    for (int j = 11; j >= 0; j--) {
                        if (dataBase[yearToIndexMap.get(year)][monthToIndexMap.get(month)] != null) {
                            System.out.println(dataBase[yearToIndexMap.get(year)][monthToIndexMap.get(month)].toString());
                        } else {
                            System.out.println("There is no entry in here\n----------------------------");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error in 'printByYearAndMonth' method: " + e);
        }
    }

    public void printAll(int opc) {
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
            System.out.println("Error in the 'printAll' method: " + e);
        }
    }
}
