import java.util.*;

public class Main {
    public static void main(String[] args){
        int answer=0;
        int[] citations = {31,66};
        Arrays.sort(citations);
        int len= citations.length;
        for(int i=0;i<=len;i++){//i는 h
            int cnt=0;
            for(int j=0;j<len;j++){
                if(i<=citations[j]){
                    cnt++;
                }
            }
            if(i<=cnt){
                answer=Math.max(i,answer);
            }
        }
        System.out.println(answer);
    }
}