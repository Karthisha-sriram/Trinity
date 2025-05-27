import java.lang.reflect.Method;

public class ReflectExample {
    public void sayHello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectExample");
        Object obj = cls.getDeclaredConstructor().newInstance();

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            if (method.getName().equals("sayHello")) {
                method.invoke(obj, "Reflection");
            }
        }
    }
}
