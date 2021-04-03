
import java.util.*;

public class Main{
   
    static int[][]dp;
    public static void main(String[] args) {
        int n=7;//지점 갯수
        int s=3; //출발지점
        int a=4; //a 도착
        int b=1; //b도착 

        int[][] fares= 	{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        dp= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=20000000;
                }
            }
        }
        
        for(int i=0;i<fares.length;i++){
            int from= fares[i][0]-1;
            int to= fares[i][1]-1;
            dp[from][to]=fares[i][2];
            dp[to][from]=fares[i][2];
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[j][k]=Math.min(dp[j][k],dp[j][i]+dp[i][k]);
                }
            }
        }
        int ans= Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[s-1][i]+dp[i][a-1]+dp[i][b-1]);
        }
    }
}
