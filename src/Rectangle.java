public class Rectangle {
    private double length, breadth;
    Rectangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
    }
    public double getArea(){
        return length * breadth;
    }
}
