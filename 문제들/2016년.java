import java.util.*;

public class Main {
    public static void main(String[] args) {
        int a=5;
        int b= 24;
        String s[] =  {"SUN","MON","TUE","WED","THU","FRI","SAT"};
        //31 29 31 30 31 30 31 31 30 31 30 31 
        String answer = "";
        int day[]={0,31,29,31,30,31,30,31,31,30,31,30,31};
        int before=0;
        for(int i=1;i<a;i++){
            before+=day[i];
        }
        before+=b;
        int cnt=5;
        cnt = (cnt + before -1)%7;
        answer= s[cnt];
        //System.out.println(answer); 

        //return answer;

    }
}
