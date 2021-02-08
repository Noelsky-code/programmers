
import java.util.*;

public class Main {
    public static void main(String[] args){
     
       int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
       String hand = "right"; 
       int[][] phone = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
       int l_row = 3;
       int r_row = 3;
       int l_col= 0;
       int r_col= 2;
       StringBuilder sb= new StringBuilder();
       for(int number:numbers){
           int row=0;
           int col=0;
            for(int i=0;i<=3;i++){
                for(int j=0;j<=2;j++){
                    if(number==phone[i][j]){
                        row=i;
                        col=j;   
                    }
                    
                }
            }//위치 찾기 
            if(col==0){//왼손 
                sb.append("L");
                l_row=row;
                l_col=col;
            }
            else if(col==2){
                sb.append("R");
                r_row=row;
                r_col=col;

            }
            else{//중앙 일 경우
                int move_l = Math.abs(row-l_row)+Math.abs(col-l_col);
                int move_r = Math.abs(row-r_row)+Math.abs(col-r_col);
                if(move_l>move_r){
                    r_row=row;
                    r_col=col;
                    sb.append("R");
                }
                else if(move_l<move_r){
                    l_row=row;
                    l_col=col;
                    sb.append("L");
                }
                else{//같을 경우 
                    if(hand=="right"){
                        r_row=row;
                        r_col=col;
                        sb.append("R");
                    }
                    else{
                        l_row=row;
                        l_col=col;
                        sb.append("L");
                    }
                }
            
            }
       }

        System.out.println(sb.toString());
    }
}
