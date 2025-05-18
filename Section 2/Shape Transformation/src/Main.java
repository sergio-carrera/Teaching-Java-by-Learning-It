import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double shapeValue;
        System.out.print("Enter a double value: ");
        shapeValue = sc.nextDouble();
        System.out.println("Initial shapeValue value: " + shapeValue);

        System.out.println("Transforming shapeValue");
        int intShapeValue = (int) shapeValue;
        System.out.println("Integer value of shapeValue: " + intShapeValue);

        long longShapeValue = (long) shapeValue;
        System.out.println("Long value of shapeValue: " + longShapeValue);

        float floatShapeValue = (float) shapeValue;
        System.out.println("Float value of shapeValue: " + floatShapeValue);

        byte byteShapeValue = (byte) shapeValue;
        System.out.println("Byte value of shapeValue: " + byteShapeValue);

        short shortShapeValue = (short) shapeValue;
        System.out.println("Short value of shapeValue: " + shortShapeValue);
    }
}