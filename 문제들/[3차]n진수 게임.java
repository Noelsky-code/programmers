
import java.util.*;

public class Main {
    
    
    public static void main(String[] args){
        int n=16;int t=16;int m=2;int p=1;
        //0부터 시작 
        String s="0123456789ABCDEF";
        s=s.substring(0,n);
        String a="";
        int cnt=0;
        //숫자 갯수는 최대 t*m 개 구해야함 
        for(int i=0;;i++){
            StringBuilder sb=new StringBuilder();
            int temp=i;
            if(i==0){
                sb.append('0');
            }
            while(temp!=0){
                char c= s.charAt(temp%n);
                temp/=n;
                sb.append(c);
            }
            a=a+sb.reverse().toString();
            if(a.length()>=t*m){
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;;i++){
            if(i%m==p-1){
                sb.append(a.charAt(i));
                t--;
            }
            if(t==0){
                break;
            }
        }
        System.out.println(sb.toString());
        System.out.println(Integer.toString(123,1));

    }

}