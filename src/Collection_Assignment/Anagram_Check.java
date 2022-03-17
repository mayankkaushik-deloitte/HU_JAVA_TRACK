package Collection_Assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram_Check {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if(predicate(s1,s2)){
            System.out.println("Anagrams");
        }else{
            System.out.println("Not Anagrams");
        }
    }
    public static boolean predicate(String s1, String s2){
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++){
            if(mp.containsKey(s1.charAt(i))){
                mp.replace(s1.charAt(i), mp.getOrDefault(s1.charAt(i),0) + 1);
            }else{
                mp.put(s1.charAt(i),1);
            }
        }
        for(int i = 0 ; i < s2.length() ; i++){
            if(mp.containsKey(s2.charAt(i))){
                mp.replace(s2.charAt(i),mp.getOrDefault(s2.charAt(i),0) - 1);
            }else{
                return false;
            }
        }
        for(Map.Entry m : mp.entrySet()){
            if((int)m.getValue() != 0){
                return false;
            }
        }
        return true;
    }
}
