
import java.util.*;

public class Main {


    public static void main(String[] args){
     
        int n=10;
        int num=3;
        int len=1;
        StringBuilder sb=new StringBuilder();
        while(n>num){
            len++;
            num=num+(int)Math.pow(3,len);
        }//길이를 구한다 . len에 저장됨 . 
       // System.out.println(num);
        int cnt=1;
        num=3;
        while(cnt<len){
            n=n-(int)Math.pow(3,cnt);
            cnt++;
        }
        cnt=0;
        while(cnt<len){
                        
            if(n%3==0){
                sb.append("4");
            }
            else{
                sb.append(n%3);
            }
            if(n>3){
                n/=3;
            }
            cnt++;
        }
        System.out.println(sb.toString());
      
    }
}