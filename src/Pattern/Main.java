package Pattern;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows you want to print : ");
        int n = sc.nextInt();
        printPattern(n);
    }
    public static void printPattern(int n){
        for (int i = 0 ; i < n ; i++){
            int spaces = n - i - 1;
            for(int j = 0 ; j < n ; j++){
                if(j < spaces){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
        for(int i = 0 ; i + 1 < n ; i++){
            int spaces = i + 1;
            for(int j = 0 ; j < n ; j++){
                if(j < spaces){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
