import java.util.*;

public class Main{
    
    public static void main(String[] args) {
    //  11개의 세로선 ,가로선  U,D 일경우 세로 선  LR : 가로선 
        String dirs ="ULURRDLLU";
        int row=5;
        int col=5;
        boolean[][] col_list=new boolean[11][10];
        boolean[][] row_list=new boolean[11][10];
        for(int i=0;i<11;i++){
            Arrays.fill(col_list[i],false);
            Arrays.fill(row_list[i],false);
        } 
        for(int i=0;i<dirs.length();i++){
            char c= dirs.charAt(i);
            if(c=='U'){
                if(row-1<0)continue;
                row=row-1;
                col_list[col][row]=true;
            }
            else if(c=='D'){
                if(row+1>10)continue;
                row=row+1;
                col_list[col][row-1]=true;

            }
            else if(c=='L'){
                if(col-1<0)continue;
                col=col-1;
                row_list[row][col]=true;
            }
            else if(c=='R'){
                if(col+1>10)continue;
                col=col+1;
                row_list[row][col-1]=true;
            }
        }
    }

}