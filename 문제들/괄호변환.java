import java.util.*;

public class Main {
    static Stack<Character> stack;
    public static void main(String[] args) {
        stack=new Stack<Character>();
        System.out.println(req(")("));

    }
    public static String req(String a){
        if(a=="")return "";
        int cnt=0;
        int cnt_a=0;//( 갯수 
        int cnt_b=0;// ) 갯수
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='(')cnt_a++;
            if(a.charAt(i)==')')cnt_b++;
            if(cnt_a==cnt_b){//균형이 맞다면 
                cnt=i+1;
                break;
            }
        }
        String u = a.substring(0, cnt);
        String v="";
        if(cnt!=a.length())v = a.substring(cnt,a.length());
        //u,v 분리 
        if(check(u)){//u가 올바른 문자열이라면 
            return u+req(v);
        }//아니라면 
        String temp = "(";
        temp=temp+req(v)+")";
        u=u.substring(1,u.length()-1);
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<u.length();i++){
            if(u.charAt(i)=='('){
                sb.append(')');
            }
            else{
                sb.append('(');
            }
        }
        return temp+sb.toString();
    }
    public static boolean check(String u){
        boolean check=true;
        for(int i=0;i<u.length();i++){
           char c = u.charAt(i);
            if(c=='('){
               stack.push(c);
            }
            else{// ')' 일 떄 
                if(stack.isEmpty()){
                    check=false;//비었다면 땡 
                    break;
                }
                else if(stack.pop()!='('){
                    check=false;
                    break;
                }
            }
       }
       return check;
    }
}