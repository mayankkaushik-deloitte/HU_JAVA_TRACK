package Exception_Handling;

public class Question_1 {
    public static void main(String []args){
        try{
            int num1 = 10;
            int num2 = 0;
            System.out.println("The division of num1 by num2 is : " + num1 / num2);//This will throw an Arithmetic exception
        }
        catch (ArithmeticException exc){
            System.out.println("Arithmetic Exception thrown");
            System.out.println("The exact error definition is : ");
            System.out.println(exc.getMessage());
        }

        finally {
            System.out.println("Thank you!");
        }
    }
}
