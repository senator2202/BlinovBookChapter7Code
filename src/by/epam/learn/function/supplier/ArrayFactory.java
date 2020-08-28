package by.epam.learn.function.supplier;

import java.util.function.Supplier;

public class ArrayFactory {
    public static Supplier<int[]> buildArray(int size) {
        final int length = size > 0 ? size : 1;
        return () -> new int[length];
    }
}