import java.util.*;

public class Main {
  
    public static void main(String[] args) {
        int brown=10;
        int yellow=2;
        //가로길이>=세로길이
        int row=0;
        int col=0;
        int all=brown+yellow;//전체 타일갯수 
        for(int i=3;;i++){//가로
            int j=all/i;//세로 
            int temp = 2*i+2*(j-2);
            if(temp==brown){
                col=Math.max(i,j);
                row=Math.min(i,j);
                break;
            }
        }
        System.out.println(col+" "+row);

    }
}