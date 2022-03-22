package Main_Assignment;

import java.util.Scanner;

import static Main_Assignment.Main.userDetails;

public class actualFunction {
    static void actualCRUD(){
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
