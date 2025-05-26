import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, String> studentMap = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            studentMap.put(id, name);
        }

        System.out.print("Enter an ID to search: ");
        int searchId = sc.nextInt();

        if (studentMap.containsKey(searchId)) {
            System.out.println("Name: " + studentMap.get(searchId));
        } else {
            System.out.println("ID not found.");
        }

        sc.close();
    }
}
