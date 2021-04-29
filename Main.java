
import java.util.*;

public class Main{

    public static void main(String[] args){
        int[][] board= {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        Robot temp = new Robot();
        System.out.println(temp.can_move_down(board));
        //만약 move할곳이 없다면 return 해줌 
    }
    //왼쪽 위쪽 오른쪽 이동 함수 구현, 갈수 있는지 없는지 구현 . 
    static void aaaa(){
        //can_move_down() ??? -> true => move 
    }
    static void rotate(){
        //can_move_down() ?? -> true  -> 아래로 rotate 가능 
    }
}

class Robot{
    int[] left;
    int[] right;
    boolean dir;//dir이 true면 가로방향 ,dir이 false면 세로로  
    public Robot(){
        left= new int[2];
        right= new int[2];
        left[0]=0;
        left[1]=0;
        right[0]=0;
        right[1]=1;
        dir=true;
    }
    public void maintain(){//왼쪽 오른쪽 기준을 잡기위함 . 항상 왼쪽이 오른쪽보다 작음
        if(this.left[0]>this.right[0]||this.left[1]<this.right[1]){
            int[] temp= this.left;
            this.left[0] = this.right[0];
            this.left[1]= this.right[1];
            this.right = this.left;
        }
    }
    public boolean can_move_down(int[][] board){
        if(dir){//누운 상태라면
            int row= this.left[0];
            if(row==board.length-1){
                return false;
            }
            if(board[row+1][this.left[1]]==0&&board[row+1][this.right[1]]==0){
                return true;
            }
            return false;
        }
        int row = this.right[0];
        if(row==board.length-1){
            return false;
        }
        if(board[row+1][this.right[1]]==0){
            return true;
        }
        return false; 
    }
    
}