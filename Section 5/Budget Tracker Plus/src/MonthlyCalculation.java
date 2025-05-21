public class MonthlyCalculation {
    private int year;
    private int month;
    private double income;
    private double rent;
    private double groceries;
    private double transportation;
    private double entertainment;
    private double totalExpenses;
    private double remainingBudget;
    private double rentPercentage;
    private double groceriesPercentage;
    private double transportationPercentage;
    private double entertainmentPercentage;

    public MonthlyCalculation(int year, int month, double income, double rent, double groceries, double transportation, double entertainment, double totalExpenses, double remainingBudget, double rentPercentage, double groceriesPercentage, double transportationPercentage, double entertainmentPercentage) {
        this.year = year;
        this.month = month;
        this.income = income;
        this.rent = rent;
        this.groceries = groceries;
        this.transportation = transportation;
        this.entertainment = entertainment;
        this.totalExpenses = totalExpenses;
        this.remainingBudget = remainingBudget;
        this.rentPercentage = rentPercentage;
        this.groceriesPercentage = groceriesPercentage;
        this.transportationPercentage = transportationPercentage;
        this.entertainmentPercentage = entertainmentPercentage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getGroceries() {
        return groceries;
    }

    public void setGroceries(double groceries) {
        this.groceries = groceries;
    }

    public double getTransportation() {
        return transportation;
    }

    public void setTransportation(double transportation) {
        this.transportation = transportation;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public void setEntertainment(double entertainment) {
        this.entertainment = entertainment;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(double totalExpenses) {
        this.totalExpenses = totalExpenses;
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void setRemainingBudget(double remainingBudget) {
        this.remainingBudget = remainingBudget;
    }

    public double getRentPercentage() {
        return rentPercentage;
    }

    public void setRentPercentage(double rentPercentage) {
        this.rentPercentage = rentPercentage;
    }

    public double getGroceriesPercentage() {
        return groceriesPercentage;
    }

    public void setGroceriesPercentage(double groceriesPercentage) {
        this.groceriesPercentage = groceriesPercentage;
    }

    public double getTransportationPercentage() {
        return transportationPercentage;
    }

    public void setTransportationPercentage(double transportationPercentage) {
        this.transportationPercentage = transportationPercentage;
    }

    public double getEntertainmentPercentage() {
        return entertainmentPercentage;
    }

    public void setEntertainmentPercentage(double entertainmentPercentage) {
        this.entertainmentPercentage = entertainmentPercentage;
    }

    @Override
    public String toString() {
        return "Monthly calculation of year: " + year + " and month: " + month + "\n" +
                "Income: " + income + "\n" +
                "Rent expense: " + rent + "\n" +
                "Groceries expense: " + groceries + "\n" +
                "Transportation expense: " + transportation + "\n" +
                "Entertainment expense: " + entertainment + "\n" +
                "Total expenses: " + totalExpenses + "\n" +
                "Remaining budget: " + remainingBudget + "\n" +
                "Rent percentage: " + rentPercentage + "\n" +
                "Groceries percentage=" + groceriesPercentage + "\n" +
                "Transportation percentage=" + transportationPercentage + "\n" +
                "Entertainment percentage=" + entertainmentPercentage + "\n" +
                "----------------------------";
    }
}
