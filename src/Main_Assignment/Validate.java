package Main_Assignment;

import java.util.InputMismatchException;

public class Validate {
    public static void validatePassword(String password){
        try {
            boolean ok_upper_case = false, ok_lower_case = false, ok_digit = false, ok_special = false;
            int len = password.length();
            if (len < 5 || len > 10) throw new InputMismatchException("Length is not in bounds");
            for (int i = 0; i < password.length(); i++) {
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
                throw new InputMismatchException("Characters don't meet requirement!");
            }
        }
        finally {
        }
    }
    public static boolean special_character(Character ch){
        return ch == '@' || ch == '#' || ch == '&' || ch == '%' || ch == '*' || ch == '!';
    }
}
