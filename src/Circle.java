public class Circle {
    private double radius;
    Circle(double radius){
        this.radius = radius;
    }
    public double getArea() {
        return 3.14 * (this.radius) * (this.radius);
    }
}
