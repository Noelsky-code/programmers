import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        int[] arr= {5,9,7,10};
        int divisor=5;

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i:arr){
            if(i%divisor==0){
                list.add(i);
            }
        }
        if(list.size()==0){
            int[] answer={-1};
        }else{
            int[] answer= new int[list.size];
             for(int i=0;i<list.size();i++){
                answer[i]=list.get(i);
             }
             Arrays.sort(answer);
        }
    }
}
