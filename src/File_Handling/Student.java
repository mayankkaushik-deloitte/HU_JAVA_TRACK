package File_Handling;

public class Student {
    private String name, reg_no_10, reg_no_12, reg_no_btech;
    private int Rank;
    public Student(String name,String reg_10,String reg_12, String reg_btech, String Rank){
        this.name = name;
        this.reg_no_10 = reg_10;
        this.reg_no_12 = reg_12;
        this.reg_no_btech = reg_btech;
        this.Rank = Integer.parseInt(Rank);
    }
    public String getName(){
        return this.name;
    }
    public String getReg_no_10(){
        return this.reg_no_10;
    }
    public String getReg_no_12(){
        return this.reg_no_btech;
    }
    public String getReg_no_btech(){
        return this.reg_no_btech;
    }
    public int getRank(){
        return this.Rank;
    }
    @Override
    public String toString(){
        return this.name + "," + this.reg_no_10 + "," + this.reg_no_12 + "," + this.reg_no_btech + "," + this.Rank;
    }
}
