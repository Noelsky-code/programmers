
import java.util.*;

public class Main {
    static int answer=0;
    static int[] arr;
    public static void main(String[] args){
        int[] numbers={1,1,1,1,1};
        int target=3;
        arr=new int[numbers.length+1];
        for(int i=1;i<=numbers.length;i++){
            arr[i]=numbers[i-1];
        }
        number(target,0,0);
        System.out.println(answer);

    }
    static void number(int target,int now,int cnt){
        if(cnt==arr.length-1){
            if(target==now){
                answer++;
                return;
            }
            else{
                return;
            }
        }
        number(target,now+arr[cnt+1]*-1,cnt+1);
        number(target,now+arr[cnt+1],cnt+1);
    }
}