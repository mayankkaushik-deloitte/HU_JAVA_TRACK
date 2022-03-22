package Main_Assignment.conversions;

import java.io.IOException;
import java.io.PrintWriter;

import static Main_Assignment.Main.loginDetails;
import static Main_Assignment.Main.userDetails;

public class ToCSV {
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
}
