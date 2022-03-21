package Main_Assignment;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static HashMap<String,String> loginDetails;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("For Login press 1.\nFor Registration press 2.");
        int input = sc.nextInt();
        try{
            if(input != 1 || input != 2) {
                throw new Exception("Input invalid");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(input == 1){
            try{
                login();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            try{
                registration();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---Welcome to Login Page---");
        System.out.println("Enter Username : ");
        String userName = sc.nextLine();
        System.out.println("Enter password : ");
        String password = sc.nextLine();
        if(!loginDetails.containsKey(userName))throw new InputMismatchException("Invalid details.");
        if(password != loginDetails.get(userName))throw new InputMismatchException("Invalid details");
    }
    static void registration(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String userName = sc.nextLine();
        System.out.println("Enter Password : ");
        String password = sc.nextLine();
        System.out.println("Re-Enter Password : ");
        String password2 = sc.nextLine();
        if(password != password2)throw new InputMismatchException("Passwords don't match");
        if(loginDetails.containsKey(userName))throw new InputMismatchException("Already Registered.");
        loginDetails.put(userName, password);
    }

}
