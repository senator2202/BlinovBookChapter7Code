package by.epam.learn.function.closure;

import java.util.function.Function;

public class ClosureMain {
    public static void main(String[] args) {
        Function<String, Integer> function = FunctionBuilder.build("100");
        int res = function.apply("77");
        System.out.println(res);
    }

    public static Function<String, Integer> build(String strNum) {
        int[] count = {1};
        ++count[0];
        return t -> Integer.valueOf(strNum + t) + ++count[0];
    }
}