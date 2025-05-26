import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Amit");
        names.add("Mohan");
        names.add("Beena");

        // Sort using lambda
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));

        System.out.println("Sorted List:");
        names.forEach(System.out::println);
    }
}
