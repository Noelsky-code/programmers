
import java.util.*;

public class Main {
   static int dp[];
    public static void main(String[] args){
        int n= 5;
        dp=new int[n+1];
        System.out.println(fibo(n)%1234567);
    } 
    static int fibo(int n){
        if(dp[n]!=0)return dp[n];
        if(n==1){
            return 1;
        }
        if(n==2){
            return 1;
        }
        return dp[n]=(fibo(n-1)%1234567+fibo(n-2)%1234567)%1234567;
        
    }
}
