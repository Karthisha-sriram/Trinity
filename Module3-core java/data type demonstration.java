import java.util.Scanner;

public class DataTypeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;
        float f;
        double d;
        char c;
        boolean b;

        System.out.print("Enter an integer: ");
        i = sc.nextInt();

        System.out.print("Enter a float: ");
        f = sc.nextFloat();

        System.out.print("Enter a double: ");
        d = sc.nextDouble();

        System.out.print("Enter a character: ");
        c = sc.next().charAt(0);

        System.out.print("Enter true or false: ");
        b = sc.nextBoolean();

        System.out.println("Integer: " + i);
        System.out.println("Float: " + f);
        System.out.println("Double: " + d);
        System.out.println("Char: " + c);
        System.out.println("Boolean: " + b);

        sc.close();
    }
}
