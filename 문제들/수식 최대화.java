
import java.util.*;

public class Main {
   
    public static void main(String[] args){
        String expression = "100-200*300-500+20";
        String[] priorities={"-+*","+-*","+*-","-*+","*+-","*-+"};
        long answer=0;        
        for(String priority:priorities){
            String temp=expression;
            boolean minus=false;
            for(int i=0;i<3;i++){
                
                String[] numbers=make_number(temp,minus);
                String[] ope = make_ope(temp,minus);
                String[] arr=make_arr(numbers,ope);
                if(priority.substring(i,i+1).equals("-")){
                    minus=true;
                }
                temp=calculation(arr,priority.substring(i,i+1));
            }
            answer=Math.max(Math.abs(Long.parseLong(temp)),answer);
        }
        System.out.println(answer);
    }
    static String[] make_number(String s,boolean minus){//숫자배열 만들기 
        
        String temp=s.replaceAll("\\+"," ");
        temp=temp.replaceAll("\\*"," ");
        if(!minus){
            temp=temp.replaceAll("\\-"," ");
        }

        return temp.split(" ");
    }
    static String[] make_ope(String s,boolean minus){//연산자 배열 만들기 
        String temp="";
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
            if(c=='+'||c=='*'){
                temp=temp+Character.toString(c);
            }
            else if(c=='-'&&!minus){
                temp=temp+Character.toString(c);
            }
        }
        return temp.split("");
    }
    static String[] make_arr(String[]numbers,String[] ope){//두개 합친 배열 만들기 
        String[] ret=new String[numbers.length+ope.length];
        int a=0;int b=0;
        for(int i=0;i<ret.length;i++){
            if(i%2==0){
                ret[i]=numbers[a++];
            }
            else{
                ret[i]=ope[b++];
            }
        }
        return ret;
    }
    static String calculation(String[]arr,String ope){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(ope)){
                long a=Long.parseLong(arr[i-1]);
                long b=Long.parseLong(arr[i+1]);
                long n=0;
                if(arr[i].equals("+")){
                    n=a+b;
                }
                else if(arr[i].equals("-")){
                    n=a-b;
    
                }
                else if(arr[i].equals("*")){
                    n=a*b;
                }
                arr[i-1]="";
                arr[i]="";
                arr[i+1]=Long.toString(n);
            }
        }
        String ret="";
        for(String s:arr){
           
            ret=ret+s;
        }
        return ret;
    }
}
