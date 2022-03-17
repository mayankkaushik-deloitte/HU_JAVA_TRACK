package Day_2_Subarray_negative;

import java.util.Scanner;

public class Main {
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0 ;  i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int getNum = findNumSubWithNegSum(arr,n);
        System.out.println(getNum);
    }
    public static int findNumSubWithNegSum(int[] arr, int n){
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int sum = 0;
            for(int j = i ; j < n ; j++){
                sum += arr[j];
                if(sum < 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
