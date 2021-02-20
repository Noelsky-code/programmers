
import java.util.*;

public class Main {
    static int a=0;//1
    static int b=0;//0
    public static void main(String[] args){
        int arr[][] ={{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int row=arr.length-1;
        int col=row;
        quad(0,row,0,col,arr);
        System.out.println(b+" "+a);
    }
    static void quad(int s_row,int e_row,int s_col,int e_col,int[][] arr){
        int sum=0;
        int mul=(e_row+1-s_row)*(e_col+1-s_col);
        for(int i=s_row;i<=e_row;i++){
            for(int j=s_col;j<=e_col;j++){
                sum+=arr[i][j];
            }
        }
        
        if(sum==0){
            b++;
            return;
        }
        else if(sum==mul){
            a++;
            return;
        }
        int m_row = (s_row+e_row)/2;
        int m_col = (s_col+e_col)/2;
        quad(s_row,m_row,s_col,m_col,arr);
        quad(s_row,m_row,m_col+1,e_col,arr);
        quad(m_row+1,e_row,s_col,m_col,arr);
        quad(m_row+1,e_row,m_col+1,e_col,arr);
    }
}