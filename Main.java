import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] answer = {};
        int[] numbers ={2,1,3,4,1};
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int len= numbers.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                map.put(numbers[i]+numbers[j],0);       
            }
        }
        int cnt=0;
        answer =new int[map.size()];
        for(int i:map.keySet()){
            answer[cnt]=i;
            cnt++;
        }
        Arrays.sort(answer);
        System.out
        
    }
}
