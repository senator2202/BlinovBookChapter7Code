package by.epam.learn.function.closure;

import java.util.function.Function;

public class FunctionBuilder<T> {
    public static Function<String, Integer> build(String strNum) {
        int count = 1;
        return t -> {
            int res = Integer.valueOf(strNum + t) + count;
            return res;
        };
        //return t -> Integer.valueOf(strNum + t) + count;
    }

    /*public static Function<String, Integer> build(String strNum) {
        int[] count = {1};
        ++count[0];
        return t -> Integer.valueOf(strNum + t) + ++count[0];
    }*/
}

/*
public class FunctionBuilder<T> {
    static int count = 1;
    public static Function<String, Integer> build(String strNum) {
        count++;
        return t -> Integer.valueOf(strNum + t) + ++count;
    }
}
*/