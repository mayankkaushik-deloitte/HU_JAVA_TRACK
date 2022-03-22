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
    public void setName(String name){
        this.name = name;
    }
    public void setUserID(String userID){
        this.userID = userID;
    }
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }
    public void setDesignation(String designation){
        this.designation = designation;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    @Override
    public String toString(){
        return this.name + "," + this.userID + "," + this.companyName + "," + this.designation + "," + this.address + "," + this.phoneNumber + "," + this.age + "," + this.salary;
    }
}
