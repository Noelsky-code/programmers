
import java.util.*;



public class Main{

    
    public static void main(String[] args){
        int[][] board = new int[5][5];
        LinkedList<Point> p = N_Queen(board, 5, 5,0);
        System.out.println();
// 0 0   1 2    2  4    3  1   4 3 
   1,1   2,3    3,5    4,2  5,4 
    }
    static LinkedList<Point> N_Queen(int[][] board,int n,int N ,int row ){
        if(n==0){
            return new LinkedList<Point>();
        }
        for(int i=0;i<N;i++){
            if(isSafe(board,row,i)){// 놓을 수 있다면
                board[row][i] = 1;
                LinkedList<Point> ret = N_Queen(board, n-1, N, row+1);
                if(ret.size()==n-1){
                    ret.add(new Point(row,i));
                    return ret;
                }
                board[row][i]= 0;
            }
        }
        return new LinkedList<Point>();
    }

    static boolean isSafe(int board[][], int row, int col){
    int i, j;
    for(i=row-1;i>=0;i--){
        if(board[i][col]==1){
            return false;
        }
    }
    for (i = 0; i < col; i++)
    {
        if (board[row][i]==1)
            return false;
    }
    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
    {
        if (board[i][j]==1)
            return false;
    }
 
    for (i = row, j = col; j >= 0 && i < 5; i++, j--)
    {
        if (board[i][j]==1)
            return false;
    }
 
    return true;
    }

}

class Point{
    int row;
    int col;
    public Point(int row,int col){
        this.row = row;
        this.col = col;
    }
}
