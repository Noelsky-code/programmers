
import java.util.*;

public class Main {
    public static void main(String[] args){
        int n=15
        ;
        int len=(int)(Math.log10(n)/Math.log10(2))+1;
        int arr[]=new int[len];
        int temp=n;
        for(int i=len-1;i>=0;i--){
            arr[i]=temp%2;
            temp/=2;
        }
        int answer=0;
        if(n==(int)Math.pow(2,len)-1){
            answer=n+(int)Math.pow(2,len)-(int)Math.pow(2,len-1);
        }
        System.out.println(answer);
       
    }
      
}
