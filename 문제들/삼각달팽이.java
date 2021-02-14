
import java.util.*;

public class Main{
    static int[] answer;
    static int[][] temp;
    public static void main(String[] args){
        int n=6;
        temp=new int[n+1][];
        int len=0;
        for(int i=1;i<=n;i++){
            temp[i]=new int[i];
            len+=i;
        }
       //System.out.println(temp.length);

        answer=new int[len];
        snail(1,0,n,1);
        int cnt=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<temp[i].length;j++){
                answer[cnt++]=temp[i][j];
            }
        }
         for(int i:answer)System.out.printf("%d ",i);
        //return answer;
        
        }
    static void snail(int row,int col,int depth,int num){
        if(row==depth){
            temp[row][col]=num;
            return;
        }
        if(row>depth){
            return;
        }
        for(int i=row;i<=depth;i++){
            temp[i][col]=num++;//아래로 이동 
        }
        for(int i=col+1;i<depth-col;i++){
            temp[depth][i]=num++;//오른쪽 이동 
        }
        for(int i=depth-1;i>row;i--){
            temp[i][i-col-1]=num++;
        }
        snail(row+2,col+1,depth-1,num);


    }





}

