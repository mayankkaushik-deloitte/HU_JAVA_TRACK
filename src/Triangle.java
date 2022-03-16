public class Triangle {
    private double first,second,third;
    Triangle (double first,double second,double third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
    private double semiPerimeter(){
        return (first + second + third) / 2;
    }
    public double getArea(){
        double s = semiPerimeter();
        double val = Math.sqrt(s * (s - first) * (s - second) * (s - third));
        return val;
    }
}
