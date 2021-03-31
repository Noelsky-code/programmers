
import java.util.*;

public class Main{
    static int[][] dp;
    public static void main(String[] args) {
        int m=4;
        int n=3;
        int[][] puddles = {{2,2}};
        int[][] map= new int[m][n];
        dp= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j]=1;
                dp[i][j]=-1;
            }
        }
        for(int i=0;i<puddles.length;i++){
            map[puddles[i][0]-1][puddles[i][1]-1]=-1;
        }
        System.out.println(find(map,0,0));
        
    }
    static int find(int[][] map,int row,int col){
        int ret=0;
        int n=map.length-1;
        int m=map[0].length-1;
        if(row==n&&col==m)return 1;
        if(row>n||col>m)return 0;
        
        if(dp[row][col]!=-1)return dp[row][col];

        ret=find(map,row+1,col)+find(map,row,col+1);

        return dp[row][col]=ret;
    }
}

