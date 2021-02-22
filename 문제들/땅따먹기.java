
import java.util.*;

public class Main {
    static int dp[][];
    static int depth;
    static int arr[][];
    public static void main(String[] args){
        int[][] land= {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        dp=new int[land.length][4];
        arr=land;
        depth=land.length;
       int answer=0;
       for(int i=0;i<4;i++){
           answer=Math.max(get_land(0,i),answer);
       }
       System.out.println(answer);
    }
    static int get_land(int cnt,int col){
        int ret=0;        
        if(cnt==depth)return 0;
        if(dp[cnt][col]!=0)return dp[cnt][col];
        for(int i=0;i<4;i++){
            if(i==col)continue;
            ret=Math.max(get_land(cnt+1,i)+arr[cnt][col],ret);
        }
        return dp[cnt][col]=ret;        
    }
      
}
