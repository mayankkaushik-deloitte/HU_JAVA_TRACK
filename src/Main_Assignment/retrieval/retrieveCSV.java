package Main_Assignment.retrieval;

import Main_Assignment.primitiveTemplate.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static Main_Assignment.Main.loginDetails;
import static Main_Assignment.Main.userDetails;

public class retrieveCSV {
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
}
