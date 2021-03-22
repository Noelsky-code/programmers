
import java.util.*;

public class Main {
    static int dp[][];
    public static void main(String[] args) {
        int[][] triangle={{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        dp=new int[triangle.length][triangle.length];
        for(int i=0;i<triangle.length;i++){
            for(int j=0;j<triangle.length;j++ ){
                dp[i][j]=-1;
            }
        }
        int ans = find(0,0,triangle);
        System.out.println(ans);
    }
    static int find(int row,int col,int[][] triangle){
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        if(row==triangle.length-1){
            return dp[row][col]=triangle[row][col];
        }
        int ret=0;
        ret=Math.max(find(row+1,col,triangle),find(row+1,col+1,triangle));
        return dp[row][col]=ret+triangle[row][col];
        
        
    }
}