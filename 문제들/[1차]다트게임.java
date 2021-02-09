
import java.util.*;

public class Main {


    public static void main(String[] args){
     
        String dartResult="1S2D*3T";
        int answer = 0;

        int len= dartResult.length();
        Stack<Integer> stack= new Stack<Integer>();
        
        for(int i=0;i<len;i++){
            char c= dartResult.charAt(i);
            if(c=='1'&&dartResult.charAt(i+1)=='0'){
                stack.push(10);
                i++;
                continue;
            }
            if(c>='0'&&c<='9'){
                stack.push(c-'0');
                continue;               
            }
            if(c=='S'){
                continue;
            }
            else if(c=='D'){
                int a=stack.pop();
                stack.push(a*a);
            }
            else if(c=='T'){
                int a= stack.pop();
                stack.push(a*a*a);
            }
           
            if(c=='*'){
                if(stack.size()==1){
                    int a=stack.pop()*2;
                    stack.push(a);
                }
                else{
                    int a=stack.pop()*2;
                    int b=stack.pop()*2;
                    stack.push(b);
                    stack.push(a);
                }
            }
            else if(c=='#'){
                stack.push(stack.pop()*(-1));
            }
        }
        while(stack.size()!=0){
            answer+=stack.pop();
        }
        System.out.println(answer);
    }
}