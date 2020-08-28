package by.epam.learn.function;

public interface Service {
    default void anOperation() { // public
        System.out.println("Service anOperation");
        this.method();
    }
    private void method() { // default not required
        System.out.println("private method");
    }
    static void action() { // public
        System.out.println("Service static action");
    }
    int define(int x1, int y1); // public abstract
    void load(); // public abstract
}