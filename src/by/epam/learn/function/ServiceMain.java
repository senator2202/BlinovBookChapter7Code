package by.epam.learn.function;

import by.epam.learn.function.impl.ServiceImpl;
import by.epam.learn.function.supplier.ArrayFactory;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.Collectors;

public class ServiceMain {
    public static void main(String[] args) {
        Service.action(); // static method
        ServiceImpl service = new ServiceImpl();
        service.define(1, 2);
        service.load();
        service.anOperation(); // default method
    }

    public static void функциональныеИнтерфейсы() {
        ShapeService rectangleService = (a, b) -> 2 * (a + b);

        ShapeService rectangleService1 = new ShapeService() {
            @Override
            public double perimeter(double a, double b) {
                return 2 * (a + b);
            }
        };
        double result = new ActionType(3, 5).action((a, b) -> (a + b) * 4);
    }

    public static void интерфейсPredicate() {
        Predicate<String> predicateStr1 = s -> s.length() < 2;
        Predicate<String> predicateStr2 = String::isBlank;
        Predicate<Integer> predicateInt = i -> i >= 9;

        System.out.println(predicateStr1.test("java")); // false
        System.out.println(predicateStr2.test(" ")); // true
        System.out.println(predicateInt.test(16)); // true

        String[] arrayStr = {"as", "a", "the", " ", "d", "on", "and", ""};
        System.out.println(Arrays.stream(arrayStr)
                .filter(s -> s.length() > 2)
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr).anyMatch(String::isBlank)); // true
        int[] arrayInt = {1, 3, 5, 9, 17, 33, 65};
        System.out.println(Arrays.stream(arrayInt).allMatch(i -> i >= 1)); // true

        Predicate<String> predicate1 = s -> s.contains("a");
        System.out.println(Arrays.stream(arrayStr)
                .filter(predicate1.and(s -> s.contains("n")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>) s -> s.contains("a")).and(s -> s.contains("n")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayInt)
                .filter(((IntPredicate) i -> i > 32).or(i -> i < 4))
                .boxed()
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(((Predicate<String>)s -> s.contains("and")).negate())
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.not(s -> s.contains("and")))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .filter(Predicate.isEqual("and"))
                .collect(Collectors.toList()));

        BiPredicate<String, Integer> biPredicate = (s, max) -> s.length() <= max;
        System.out.println(biPredicate.test("java", 7));
    }

    public static void интерфейсFunction() {
        Function<String, Integer> fun1 = s -> s.length();// String to Integer
        Function<Integer, String> fun2 = i -> Integer.toBinaryString(i);//int to String

        System.out.println(fun1.apply("internazionalization"));

        System.out.println(fun2.apply(20));

        String[] arrayStr = {"as", "a", "the", "d", "on", "and"};
        System.out.println(Arrays.stream(arrayStr)
                .map(fun1)
                .collect(Collectors.toList()));

        Function<Integer, Integer> fun3 = fun1.compose(fun2);

        Function<Integer, Integer> fun31 = fun1.compose(i -> Integer.toBinaryString(i));

        System.out.println(fun1.compose(fun2).apply(17));

        int[] arrayInt = { 1, 3, 5, 9, 17, 33, 65};
        System.out.println(Arrays.stream(arrayInt)
                .boxed()
                .map(fun1.compose(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayInt)
                .boxed()
                .map(((Function<String, Integer>)s -> s.length())
                        .compose(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        Function<String, String> fun4 = fun1.andThen(fun2);

        Function<String, String> fun41 = fun1.andThen(i -> Integer.toBinaryString(i));

        System.out.println(Arrays.stream(arrayStr)
                .map(fun1.andThen(i -> Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        System.out.println(Arrays.stream(arrayStr)
                .map(((Function<String, Integer>)s -> s.length()).andThen(i ->
                        Integer.toBinaryString(i)))
                .collect(Collectors.toList()));

        UnaryOperator<Integer> operator = i -> ++i;
        System.out.println(operator.apply(1)); // 2

        BiFunction<Double, String, Integer> bi = (d, s) -> (Double.toString(d) + s).length();
        int length = bi.apply(1.23, "java");
        System.out.println(length);

        BinaryOperator<String> binaryOperator = (s1, s2) -> s1 + s2.toUpperCase();
        System.out.println(binaryOperator.apply("oracle", "epam"));
    }

    public static void интефейсConsumer() {
        String str = "as a- the-d -on and";
        String regex = "-";
        Consumer<String> consumer = s -> System.out.println(Arrays.toString(s.split(regex)));
        consumer.accept(str);
    }

    public static void интерфейсSupplier() {
        Supplier<StringBuilder> supplier = () -> new StringBuilder("java");
        StringBuilder builder = supplier.get();
        Supplier<int[]> supplier2 = () -> new int[10];
        int[] arr = supplier2.get();

        int[] array = ArrayFactory.buildArray(10).get();
    }
}
