package by.epam.learn.function;

public interface ServiceApp {
    default void anOperation() { // public
        System.out.println("ServiceApp anOperation");
    }
}
