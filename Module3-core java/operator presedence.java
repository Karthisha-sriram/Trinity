import java.util.Scanner;

public class OperatorPrecedence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;
        System.out.print("Enter value for a: ");
        a = sc.nextInt();

        System.out.print("Enter value for b: ");
        b = sc.nextInt();

        System.out.print("Enter value for c: ");
        c = sc.nextInt();

        int result1 = a + b * c;
        int result2 = (a + b) * c;

        System.out.println("Result of a + b * c: " + result1);
        System.out.println("Result of (a + b) * c: " + result2);

        sc.close();
    }
}
