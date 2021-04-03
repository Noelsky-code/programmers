
import java.io.*;
import java.util.*;

public class Main{
   
   
    public static void main(String[] args) throws IOException {
        String s = "abcde";
        boolean[][] dp= new boolean[s.length()][s.length()];
        int len= s.length();
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }
        int answer=1;
        for(int i=0;i<len-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
            }
        }
        
        for(int i=2;i<len;i++){
            for(int j=0;j<len-i;j++){
                int now= j+i;
                if(s.charAt(j)==s.charAt(now)&&dp[j+1][now-1]){
                    dp[j][now]=true;
                    answer=Math.max(now-j+1,answer);
                }
            }
        }
        System.out.println(answer);
        
    }
}
