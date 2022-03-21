package File_Handling;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Student {
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
        return this.name + " " + this.reg_no_10 + " " + this.reg_no_12 + " " + this.reg_no_btech + " " + this.Rank;
    }
}
public class Student_data_filter {
    public static void main(String []args){
        String path = "C:\\Users\\mayakaushik\\Java Track\\src\\StudentsData.csv";
        String line = "";
//        int i = 0;
        ArrayList<Student> arr = new ArrayList<Student>();
        int t = 1;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                if(t == 1){
                    t++;
                    continue;
                }
                arr.add(new Student(values[0], values[1], values[2], values[3], values[4]));
//                System.out.println(arr.get(t).get(0) + " " + arr.get(t).get(1));
                t++;
            }
            Collections.sort(arr, (a,b) -> a.getRank() - b.getRank());
            for(int i = 1 ; i <= 5 ; i++){
                System.out.println(arr.get(i));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
