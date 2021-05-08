
import java.util.*;



public class Main{

    static int inf;
    static int n;
    static int m;
    static int dp[][];
    static int g_board[][];
    static int answer;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        
        n= board.length;
        m= board[0].length;
        inf = 987654321;
        answer=inf;
        dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=inf;
            }
        }
        g_board= board;
        boolean[][] visit = new boolean[n][m];
        visit[0][0]= true;
        
        dfs(0,0,-1,visit,0);
        
    } 
    static void dfs(int row,int col,int dir,boolean[][] visit,int cost){//dir 0은 가로 dir 1은 세로방향
        
        /*if(dp[row][col]!=inf){
            
            return dp[row][col];
        }*/
        if(dp[row][col]<cost){
            dp[row][col]=cost;
        }
        if(cost>answer){
            return;
        }
        if(row==n-1&&col==m-1){
            answer=Math.min(answer,cost);
            return; 
        }
        

        for(int i=0;i<4;i++){
            int next_row = move[i][0]+row;
            int next_col = move[i][1]+col;
            if(can_move(next_row,next_col)&&!visit[next_row][next_col]){
                visit[next_row][next_col]=true;
                if(((get_dir(i)==dir||dir==-1))&&dp[row][col]-100<dp[next_row][next_col]){
                    dp[next_row][next_col]=cost+100;
                    dfs(next_row,next_col,get_dir(i),visit,cost+100);
                    
                }
                else if(dp[row][col]-600 < dp[next_row][next_col]){
                    dp[next_row][next_col]=dp[row][col]+600;
                    dfs(next_row,next_col,get_dir(i),visit,cost+600);
                    
                }
                visit[next_row][next_col]=false;
                
            }        
        }
           
    }
    static boolean can_move(int next_row,int next_col){
        if(next_row<0||next_row>=n||next_col<0||next_col>=m){
            return false;
        }
        if(g_board[next_row][next_col]==0){
            return true;
        }
        return false;
    }
    static int get_dir(int i){
        if(i==0||i==1){
            return 0;
        }
        return 1;
    }
}