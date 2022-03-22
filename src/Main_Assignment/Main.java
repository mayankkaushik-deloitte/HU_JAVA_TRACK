package Main_Assignment;


import Main_Assignment.primitiveTemplate.User;

import java.util.*;

import static Main_Assignment.Validate.validatePassword;
import static Main_Assignment.actualFunction.actualCRUD;
import static Main_Assignment.conversions.ToCSV.toCSVData;
import static Main_Assignment.conversions.ToCSV.toCSVReg;
import static Main_Assignment.retrieval.retrieveCSV.retrievePrevDetails;


public class Main {
    public static HashMap<String,String> loginDetails = new HashMap<>();
    public static ArrayList<User> userDetails = new ArrayList<User>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("For Login press 1.\nFor Registration press 2.");
        int input = sc.nextInt();
        try{
            if(input != 1 && input != 2) {
                throw new Exception("Input invalid");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        retrievePrevDetails();
        if(input == 1){
            try{
                login();
                System.out.println("Login successful.");
                actualCRUD();
            }
            catch (Exception e){
                System.out.println("Login Unsuccessful.");
            }
        }else{
            try{
                registration();
                toCSVReg();
                System.out.println("Registration successful.");
                actualCRUD();
                toCSVData();
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
        if(!password.equals(loginDetails.get(userName)))throw new InputMismatchException("Invalid details");
    }
    static void registration(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Username : ");
        String userName = sc.nextLine();
        System.out.println("Enter Password : ");
        String password = sc.nextLine();
        System.out.println("Re-Enter Password : ");
        String password2 = sc.nextLine();
        try{
//            validatePassword(password);
            if(!password.equals(password2))throw new InputMismatchException("Passwords don't match");
            if(!loginDetails.isEmpty() && loginDetails.containsKey(userName))throw new InputMismatchException("Already Registered.");
            loginDetails.put(userName, password);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
