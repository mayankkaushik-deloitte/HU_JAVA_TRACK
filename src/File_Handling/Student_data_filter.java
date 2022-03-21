package File_Handling;

import java.io.*;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student_data_filter {
    public static void main(String []args){
        String path = "C:\\Users\\mayakaushik\\Java Track\\src\\File_Handling\\StudentsData.csv";
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
            for(int i = 0 ; i < 5 ; i++){
                System.out.println(arr.get(i));
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        PrintWriter pw = null;
        String filename = "C:\\Users\\mayakaushik\\Java Track\\src\\File_Handling\\ResultData.csv";
        try{
            pw = new PrintWriter(filename);
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        for(int i = 0 ; i < 5 ; i++){
            pw.println(arr.get(i).toString());
        }
        pw.flush();
        pw.close();
    }
}
