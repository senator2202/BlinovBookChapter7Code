package by.epam.learn.function;

public class ActionType {
    private double x;
    private double y;

    public ActionType(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double action(ShapeService service) {
        return 10 * service.perimeter(x, y);
    }
}