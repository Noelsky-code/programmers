import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer=0;
        int n= 125;
        int a[]=new int [100];
        //1억 log 3  
        int cnt=0;
        while(n!=0){
            a[cnt]=n%3;
            n/=3;
            cnt++;
        }
        int mul=1;
        for(int i=cnt-1;i>=0;i--){
            answer+=mul*a[i];
            mul*=3;
        }
        System.out.println(answer);
    
    }
}
