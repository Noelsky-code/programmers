
import java.util.*;

public class Main {
    //A,C,F,J,M,N,R,T 8개 
    static int answer;
    static String[] names={"A","C","F","J","M","N","R","T"};
    public static void main(String[] args){
        String[] data={"N~F=0", "R~T>2"};
        int n=2;
        for(int i=0;i<8;i++){
            make(1<<(i+1),names[i],1,data);
        }
        System.out.println(answer);

    }
    static void make(int num,String s,int cnt,String[] data){
        if(cnt==8){
            if(find(s,data)){
                answer++;
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(((1<<(i+1))&num)!=(1<<(i+1))){
                make(num|1<<(i+1),s+names[i],cnt+1,data);
            }
        }
    }
    static boolean find(String s,String[] data){
        for(String i:data){
            char a=i.charAt(0);
            char b=i.charAt(2);
            char c=i.charAt(3);
            int dis=i.charAt(4)-'0';
            int dis_a=s.indexOf(a);
            int dis_b=s.indexOf(b);
            int dis_ab=Math.abs(dis_a-dis_b)-1;
            if(c=='='){
                if(dis_ab!=dis)return false;
            }
            else if(c=='>'){
                if(dis_ab<=dis){
                    return false;
                }
            }
            else if(c=='<'){
                if(dis_ab>=dis){
                    return false;
                }
            }
        }

        return true;
    }
}