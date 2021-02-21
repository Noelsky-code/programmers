
import java.util.*;

public class Main {
    public static void main(String[] args){
        int n=78;
        int len=(int)(Math.log10(n)/Math.log10(2))+1;
        int arr[]=new int[len];
        int temp=n;
        for(int i=len-1;i>=0;i--){
            arr[i]=temp%2;
            temp/=2;
        }
       
    }
      
}
