public class Food {
    String foodName;
    double calories;
    int weekNum;
    int dayOfWeekNum;

    public Food(String foodName, double calories, int weekNum, int dayOfWeekNum) {
        this.foodName = foodName;
        this.calories = calories;
        this.weekNum = weekNum;
        this.dayOfWeekNum = dayOfWeekNum;
    }

    @Override
    public String toString() {
        return "Food Name: " + foodName + "\n" + "Calories: " + calories + "\n" + "Week: " +
                weekNum + "\n" + "Day of Week: " + dayOfWeekNum + "\n";
    }
}
