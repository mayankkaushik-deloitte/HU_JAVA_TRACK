package Main_Assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class Main {
    static HashMap<String,String> loginDetails = new HashMap<>();
    static ArrayList<User> userDetails = new ArrayList<User>();
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
        if(input == 1){
            try{
                login();
                System.out.println("Login successful.");
                actualFunction();
            }
            catch (Exception e){
                System.out.println("Login Unsuccessful.");
            }
        }else{
            try{
                registration();
                System.out.println("Registration successful.");
                actualFunction();
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
        if(!password.equals(password2))throw new InputMismatchException("Passwords don't match");
        if(!loginDetails.isEmpty() && loginDetails != null && loginDetails.containsKey(userName))throw new InputMismatchException("Already Registered.");
        loginDetails.put(userName, password);
    }
    static void actualFunction(){
        System.out.println("Welcome to the User DB--");
        Scanner sc = new Scanner(System.in);
        while(true){
            showOptions();
            int option = sc.nextInt();
            if(option == 1){
                addData();
            }else if(option == 2){
                listData();
            }else if(option == 3){
                updateData();
            }else if(option == 4){
                deleteData();
            }else{
                System.out.println("Program ends here.");
                return;
            }
        }
    }
    static void addData(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the userID : ");
        String uID = sc.nextLine();
        System.out.println("Enter the name : ");
        String name = sc.nextLine();
        System.out.println("Enter the companyName : ");
        String companyName = sc.nextLine();
        System.out.println("Enter the Designation : ");
        String designation = sc.nextLine();
        System.out.println("Enter the Address: ");
        String address = sc.nextLine();
        System.out.println("Enter the Phone Number  : ");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter the Age : ");
        int age = sc.nextInt();
        System.out.println("Enter the Salary : ");
        int salary  = sc.nextInt();

        userDetails.add(new User(uID, name, companyName, designation, address, phoneNumber,age,salary));
    }
    static void listData(){
        System.out.println("Name :- " + "UserID :- " + "CompanyName :- " + "Designation :- " + "Address :- " + "PhoneNumber :- " + "Age :- " + "Salary :- ");
        int serial = 1;
        for(User e : userDetails){
            System.out.print(serial + ". ");
            System.out.println(e.getName() + " " + e.getUserID() + " " + e.getCompanyName() + " " + e.getDesignation() + " " + e.getAddress() + " " + e.getPhoneNumber() + " " + e.getAge() + " " + e.getSalary());
        }
        System.out.println("--------------------------------------x--------------------------------------");
    }
    static void deleteData(){

    }
    static void updateData(){

    }
    static void showOptions(){
        System.out.println("1. Add user data\n2. List user data\n3. Update user data\n4. Delete user data\n5. Exit");
    }
}
