import java.util.*;
import java.util.stream.Collectors;

public class StreamEven {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> evens = numbers.stream()
                                     .filter(n -> n % 2 == 0)
                                     .collect(Collectors.toList());

        System.out.println("Even Numbers:");
        evens.forEach(System.out::println);
    }
}
