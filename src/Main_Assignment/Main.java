package Main_Assignment;

import File_Handling.Student;

import java.io.*;
import java.util.*;
import java.util.stream.StreamSupport;


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
                actualFunction();
            }
            catch (Exception e){
                System.out.println("Login Unsuccessful.");
            }
        }else{
            try{
                registration();
                toCSVReg();
                System.out.println("Registration successful.");
                actualFunction();
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
        if(!password.equals(password2))throw new InputMismatchException("Passwords don't match");
        if(!loginDetails.isEmpty() && loginDetails.containsKey(userName))throw new InputMismatchException("Already Registered.");
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
            System.out.print(serial++ + ". ");
            System.out.println(e.getName() + " " + e.getUserID() + " " + e.getCompanyName() + " " + e.getDesignation() + " " + e.getAddress() + " " + e.getPhoneNumber() + " " + e.getAge() + " " + e.getSalary());
        }
        System.out.println("--------------------------------------x--------------------------------------");
    }
    static void deleteData(){
        System.out.println("Name :- " + "UserID :- " + "CompanyName :- " + "Designation :- " + "Address :- " + "PhoneNumber :- " + "Age :- " + "Salary :- ");
        int serial = 1;
        for(User e : userDetails){
            System.out.print(serial++ + ". ");
            System.out.println(e.getName() + " " + e.getUserID() + " " + e.getCompanyName() + " " + e.getDesignation() + " " + e.getAddress() + " " + e.getPhoneNumber() + " " + e.getAge() + " " + e.getSalary());
        }
        System.out.println();
        System.out.println("Enter the serial no. which you want to delete :");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        userDetails.remove(option - 1);
        listData();
    }
    static void updateData(){
        Scanner sc = new Scanner(System.in);
        listData();
        System.out.println("Choose the user whose details you want to update : ");
        int serial = sc.nextInt();
        System.out.println("Choose the serial below to update that specific field.");
        System.out.println("1. Name");
        System.out.println("2. Designation");
        System.out.println("3. Address");
        System.out.println("4. Company Name");
        System.out.println("5. Salary");
        System.out.println("6. Phone Number");
        int option = sc.nextInt();
        if(option == 1) {
            System.out.println("Enter name : ");
            String newName = sc.nextLine();
            userDetails.get(serial - 1).setName(newName);
        }else if(option == 2) {
            System.out.println("Enter Designation : ");
            String designation = sc.nextLine();
            userDetails.get(serial - 1).setDesignation(designation);
        }else if(option == 3) {
            System.out.println("Enter Address : ");
            String address = sc.nextLine();
            userDetails.get(serial - 1).setAddress(address);
        }else if(option == 4) {
            System.out.println("Enter Company Name : ");
            String companyName = sc.nextLine();
            userDetails.get(serial - 1).setAddress(companyName);
        }else if(option == 5) {
            System.out.println("Enter salary : ");
            int salary = sc.nextInt();
            userDetails.get(serial - 1).setSalary(salary);
        }else if(option == 6) {
            System.out.println("Enter Phone Number : ");
            String phoneNo = sc.nextLine();
            userDetails.get(serial - 1).setPhoneNumber(phoneNo);
        }
//        listData();
    }
    static void showOptions(){
        System.out.println("1. Add user data\n2. List user data\n3. Update user data\n4. Delete user data\n5. Exit");
    }
}
