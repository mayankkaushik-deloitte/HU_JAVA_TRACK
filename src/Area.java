public class Area {
    public void printCircle(double radius){
        Circle obj1 = new Circle(radius);
        System.out.println(obj1.getArea());
    }
    public void printRect(double length,double breadth){
        Rectangle obj1 = new Rectangle(length,breadth);
        System.out.println(obj1.getArea());
    }
    public void printSquare(double side){
        Square obj1 = new Square(side);
        System.out.println(obj1.getArea());
    }
    public void printTriangle(double first,double second,double third){
        Triangle obj1 = new Triangle(first,second,third);
        System.out.println(obj1.getArea());
    }
}
