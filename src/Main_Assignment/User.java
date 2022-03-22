package Main_Assignment;

public class User {
    private String userID, name, companyName, designation, address, phoneNumber;
    private int age, salary;
    public User(String userID,String name, String companyName, String designation, String address, String phoneNumber, int age,int salary){
        this.userID = userID;
        this.name = name;
        this.companyName = companyName;
        this.designation = designation;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.salary = salary;
    }
    public String getName(){
        return this.name;
    }
    public String getUserID(){
        return this.userID;
    }
    public String getAddress(){
        return this.address;
    }
    public String getCompanyName(){
        return this.companyName;
    }
    public String getDesignation(){
        return this.designation;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public int getSalary(){
        return this.salary;
    }
    public int getAge(){
        return this.age;
    }
}
