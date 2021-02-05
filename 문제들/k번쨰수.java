
import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] array={1, 5, 2, 6, 3, 7, 4};
        int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int n= commands.length;
        int[] answer=new int[n];
        int row=0;
        while(row!=n){
            int len = commands[row][1]-commands[row][0]+1;
            int k= commands[row][2];
            int[] temp = new int[len];
            int cnt=0;
            for(int i=commands[row][0]-1;i<=commands[row][1]-1;i++){
                temp[cnt++]=array[i];
            }
            Arrays.sort(temp);
            answer[row]=temp[k-1];
            
            
            
            row++;
        }    
        for(int i:answer){
            System.out.println(i);
        }





    }
}
