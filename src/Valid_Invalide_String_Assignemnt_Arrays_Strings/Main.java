package Valid_Invalide_String_Assignemnt_Arrays_Strings;

import java.util.Scanner;

public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        if(predicate(s1,s2,s3)){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
    public static boolean predicate(String s1, String s2, String s3){
        int j = 0;
        int n = s3.length();
        int []visited = new int[n];
        for(int i = 0 ; i < s1.length() ; i++){
            boolean flag = false;
            while(j < s3.length()){
                if(visited[j] == 0 && s1.charAt(i) == s3.charAt(j)){
                    visited[j] = 1;
                    j++;
                    flag = true;
                    break;
                }
                j++;
            }
            if(!flag){
                return false;
            }
        }
        j=0;
        for(int i = 0 ; i < s2.length() ; i++){
            boolean flag = false;
            while(j < s3.length()){
                if(visited[j] == 0 && s2.charAt(i) == s3.charAt(j)){
                    flag = true;
                    visited[j] = 1;
                    j++;
                    break;
                }
                j++;
            }
            if(!flag){
                return false;
            }
        }
        return true;
    }
}
