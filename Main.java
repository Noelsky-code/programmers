import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        //String s= "abcabcdede";
        int n=1;
        int answer = s.length();
        int len= s.length();
        while(n<=len/2){
            
            int ret=0;

            String[] temp = new String[(len/n)+1];
            int cnt=0;
            for(int i=0;cnt<(len/n);i+=n){
            
                temp[cnt++]=s.substring(i, i+n);//cnt에 배당완료 
                 //System.out.println(temp[cnt-1]);
            }
            cnt=0;//동일한거 카운트하기 
            Stack<String> stack = new Stack<String>();
            stack.push(temp[0]);
            for(int i=1;i<(len/n);i++){
                if(temp[i].equals(stack.peek())){
                   cnt++;     
                }
                else{
                    ret+=n;
                    if(cnt>0){
                        ret++;
                        cnt=0;
                    }
                    stack.pop();
                    stack.push(temp[i]);
                }
            }
            if(cnt>0){
                ret++;
            }
            ret+=n;
            answer=Math.min(answer,ret);
           // System.out.println();
            
            n++;
        }
        System.out.println(answer);

    }
       
}