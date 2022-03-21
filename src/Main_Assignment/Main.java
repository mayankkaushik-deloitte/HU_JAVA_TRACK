package Main_Assignment;

import java.util.HashMap;
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
    public static void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---Welcome to Login Page---");
        System.out.println("Enter Username : ");
        String userName = sc.nextLine();
        System.out.println("Enter password : ");
        String password = sc.nextLine();
        if(loginDetails.containsKey(userName)){
            try{
                if(loginDetails.get(userName) != password){
                    throw new Exception("Incorrect Login Details.");
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else {
            throw new Exception("Incorrect Login Details.");
        }
    }
    public static void registration(){

    }

}
