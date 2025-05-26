public class PatternSwitch {
    public static void typeCheck(Object obj) {
        String result = switch (obj) {
            case Integer i -> "It's an Integer: " + i;
            case String s -> "It's a String: " + s;
            case Double d -> "It's a Double: " + d;
            case null -> "It's null.";
            default -> "Unknown type.";
        };

        System.out.println(result);
    }

    public static void main(String[] args) {
        typeCheck(42);
        typeCheck("Java");
        typeCheck(3.14);
        typeCheck(null);
    }
}
