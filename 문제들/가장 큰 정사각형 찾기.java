
import java.util.*;

public class Main {
    static int a=0;//1
    static int b=0;//0
    public static void main(String[] args){
        int[][] board={{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        //10^9 전체탐색 
        int answer=0;
        int arr[][]= new int[board.length+1][board[0].length+1];
        for(int i=1;i<board.length+1;i++){
            for(int j=1;j<board[0].length+1;j++)arr[i][j]=board[i-1][j-1];
        }
        
        for(int i=1;i<board.length+1;i++){
            for(int j=1;j<board[0].length+1;j++){
                if(arr[i][j]==0)continue;
                arr[i][j]=Math.min(arr[i-1][j],Math.min(arr[i-1][j-1],arr[i][j-1]))+1;
                answer= Math.max(arr[i][j],answer);
            }
        }
      
      
    }
