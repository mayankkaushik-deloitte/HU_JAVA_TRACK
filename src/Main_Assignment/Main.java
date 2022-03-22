package Main_Assignment;


import java.io.*;
import java.util.*;

import static Main_Assignment.Validate.validatePassword;
import static Main_Assignment.actualFunction.actualCRUD;


public class Main {
    static HashMap<String,String> loginDetails = new HashMap<>();
    public static ArrayList<User> userDetails = new ArrayList<User>();
    public static void toCSVData(){
        PrintWriter pw = null;
        String fileName = "C:\\Users\\mayakaushik\\Java Track\\src\\Main_Assignment\\models\\data.csv";
        try{
            pw = new PrintWriter(fileName);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        for(int i = 0 ; i < userDetails.size() ; i++){
            pw.println((userDetails.get(i).toString()));
        }
        pw.flush();pw.close();
    }
    public static void toCSVReg(){
        PrintWriter pw = null;
        String fileName = "C:\\Users\\mayakaushik\\Java Track\\src\\Main_Assignment\\models\\regDetails.csv";
        try{
            pw = new PrintWriter(fileName);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        for(String key : loginDetails.keySet()){
            pw.println(key + "," + loginDetails.get(key));
        }
        pw.flush();pw.close();
    }
    public static void retrievePrevDetails(){
        String path = "C:\\Users\\mayakaushik\\Java Track\\src\\Main_Assignment\\models\\data.csv";
        String line = "";
//        int i = 0;
        int t = 1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                userDetails.add(new User(values[0],values[1], values[2],values[3],values[4],values[5],Integer.parseInt(values[6]),Integer.parseInt(values[7])));
                t++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        String path2 = "C:\\Users\\mayakaushik\\Java Track\\src\\Main_Assignment\\models\\regDetails.csv";
        String line2 = "";
//        int i = 0;
        t = 1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path2));
            while((line2 = br.readLine()) != null) {
                String[] values = line2.split(",");
                loginDetails.put(values[0], values[1]);
                t++;
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
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
        try{
            validatePassword(password);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
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
        if(!password.equals(password2))throw new InputMismatchException("Passwords don't match");
        if(!loginDetails.isEmpty() && loginDetails.containsKey(userName))throw new InputMismatchException("Already Registered.");
        loginDetails.put(userName, password);
    }
}
