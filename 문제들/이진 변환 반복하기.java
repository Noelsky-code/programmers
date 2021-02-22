
import java.util.*;

public class Main {
   
    public static void main(String[] args){
        String s= "110010101001";
        int del=0;
        int cnt=0;
        while(!s.equals("1")){
            int before = s.length();
            s=s.replaceAll("0","");
            int len=s.length();
            del+=before-len;
            StringBuilder sb = new StringBuilder();
            while(len!=0){
                sb.append(len%2);
                len/=2;
            }
            s=sb.reverse().toString();
            cnt++;
                
        }
        int answer[]={cnt,del};
        
    } 
}
