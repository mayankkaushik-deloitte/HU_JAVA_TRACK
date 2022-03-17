package Collection_Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.util.Collections.reverse;

public class Reverse_A_List {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>(n);
        for(int i = 0 ; i <= n ; ++i){
            String each = sc.nextLine();
            arr.add(each);
        }
        Collections.reverse(arr);
        print_list(arr);
    }
    public static void print_list(ArrayList<String> arr){
        for(String each : arr){
            System.out.print(each + " ");
        }
        System.out.println();
    }
}
