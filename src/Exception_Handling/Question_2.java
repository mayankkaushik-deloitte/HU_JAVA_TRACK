package Exception_Handling;

import java.util.Scanner;

public class Question_2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password : ");
        String password = sc.nextLine();
        try {
            boolean ok_upper_case = false,ok_lower_case = false, ok_digit = false,ok_special = false;
            int len = password.length();
            if(len < 5 || len > 10)throw new Exception();
            for(int i = 0 ; i < password.length() ; i++) {
                char ch = password.charAt(i);
                if (Character.isUpperCase(ch)) {
                    ok_upper_case = true;
                }
                if (Character.isLowerCase(ch)) {
                    ok_lower_case = true;
                }
                if (Character.isDigit(ch)) {
                    ok_digit = true;
                }
                if (special_character(ch)) {
                    ok_special = true;
                }
            }
            if (!(ok_special && ok_digit && ok_lower_case && ok_upper_case)) {
                throw new Exception();
            }
            System.out.println("Password is good!");
        }
        catch (Exception e){
            System.out.println("Bad Password, Errrr!");
            System.out.println("Password must have a length between 5 and 10 inclusive. \nPassword must have at least one lowercase, one uppercase, one digit, one special character : @ # & ! * %");
        }

    }
    public static boolean special_character(Character ch){
        return ch == '@' || ch == '#' || ch == '&' || ch == '%' || ch == '*' || ch == '!';
    }
}
