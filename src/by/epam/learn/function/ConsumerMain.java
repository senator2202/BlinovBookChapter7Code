package by.epam.learn.function;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {
        String str = "as a- the-d -on and";
        String regex1 = "\\s";
        Consumer<String> consumer1 = s -> Arrays.toString(s.split(regex1));
        String regex2 ="a";
        Consumer<String> consumer2 = consumer1
                .andThen(s -> System.out.println(Arrays.toString(s.split(regex2))));
        consumer2.accept(str);
    }
}
