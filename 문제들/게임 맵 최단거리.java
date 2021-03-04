import java.util.*;

class Solution {
    static int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] maps) {
        
           LinkedList<Point> list=new LinkedList<Point>();
        boolean[][] visit=new boolean[maps.length][maps[0].length];
         for(int i=0;i<maps.length;i++)Arrays.fill(visit[i],false);
        list.add(new Point(0,0,1));
        visit[0][0]=true;
        if(0==maps.length-1&&0==maps[0].length-1)return 1;
        while(!list.isEmpty()){
            Point temp= list.pollFirst();
            for(int i=0;i<4;i++){
                int n_row=temp.row+move[i][0];
                int n_col=temp.col+move[i][1];
                if(n_row>=0&&n_row<maps.length&&n_col>=0&&n_col<maps[0].length&&maps[n_row][n_col]==1&&!visit[n_row][n_col]){
                    if(n_row==maps.length-1&&n_col==maps[0].length-1){
                        return temp.cnt+1;
                    }
                    list.addLast(new Point(n_row,n_col,temp.cnt+1));
                    visit[n_row][n_col]=true;
                } 
            }
        }
        return -1;
    }
}

class Point{
    int row;
    int col;
    int cnt;
    public Point(int row,int col,int cnt){
        this.row=row;
        this.col=col;
        this.cnt=cnt;
    }
}