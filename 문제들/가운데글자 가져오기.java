import java.util.*;

public class Main {
    public static void main(String[] args) {
        String answer="";
        String s= "a";

        int len= s.length();
        int cnt = len/2;
        if(len%2==0){
           answer=s.substring(cnt-1,cnt+1);
        }
        else if(len%2==1){
            answer=s.substring(cnt, cnt + 1);
        }


        System.out.println(answer);

    }
}