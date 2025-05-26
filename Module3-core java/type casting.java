import java.util.Scanner;

public class TypeCastingExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a double value: ");
        double d = sc.nextDouble();
        int castedInt = (int) d;

        System.out.print("Enter an integer value: ");
        int i = sc.nextInt();
        double castedDouble = i;

        System.out.println("Double to int: " + castedInt);
        System.out.println("Int to double: " + castedDouble);

        sc.close();
    }
}
