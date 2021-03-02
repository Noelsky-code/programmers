
import java.util.*;

public class Main {/*
1 1 1 0
1 2 2 0
1 0 0 1
0 0 0 1
0 0 0 3
0 0 0 3
    
    */ 
    //시간 복잡도 생각 x 
    static int[][] move={{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args){
        int m=6;
        int n=4;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] picture={{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        boolean[][] visit=new boolean[m][n];
        for(int i=0;i<m;i++)Arrays.fill(visit[i],false);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int temp=find(i,j,visit,picture,picture[i][j]);
                //System.out.println(temp);
                maxSizeOfOneArea=Math.max(maxSizeOfOneArea,temp);
                if(temp!=0)numberOfArea++;
            }
        }
        System.out.println();

    }
    static int find(int row,int col,boolean[][] visit,int[][] picture,int num){
        if(visit[row][col]){
            return 0;
        }
        if(picture[row][col]==0){
            return 0;
        }
        int ret=0;
        visit[row][col]=true;
        for(int i=0;i<4;i++){
           
            int n_row=row+move[i][0];
            int n_col=col+move[i][1];
            if(n_row<picture.length&&n_row>=0&&n_col<picture[0].length&&n_col>=0){
                if(!visit[n_row][n_col]&&picture[n_row][n_col]==num){
                    ret+=find(n_row,n_col,visit,picture,num);
                }
            }
         }
        
        return ret+1;
    }
}