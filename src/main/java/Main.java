import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Printing a message using a lambda");
        Messages messages = str -> "Hi " + str;
        System.out.println(messages.print("batman"));

        System.out.println("\nUsing a lambda that uses multiple parameters");
        Calculations calculations = (a, b) -> a + b;
        System.out.println(calculations.sum(5, 5));

        System.out.println("\nUsing a lambda that uses a body to allow multiline implementation");
        List<String> words = new ArrayList<String>();
        words.add("hi");
        words.add("batman");
        words.forEach(str -> {
            System.out.print(str);;
            System.out.print(" ");
        });
        words.forEach(str -> System.out.print(str + " "));

        System.out.println("\n\nPassing in a lambda into a function");
        System.out.println(accountingSum(5, 6, calculations));

        System.out.println("\nPrinting default method in functional interface");
        Flyable somethingFlying = message -> message;
        System.out.println(somethingFlying.speak("You can fly"));
    }

    public static int accountingSum(int a, int b, Calculations calculations) {
        return calculations.sum(a, b);
    }
}

@FunctionalInterface
interface Messages {
    String print(String message);
}

@FunctionalInterface
interface Calculations {
    int sum(int a, int b);
}

@FunctionalInterface
interface Flyable {
    String speak(String message);

    // Default methods can have method body
    default String canFly() {
        return "I am able to fly";
    };
}