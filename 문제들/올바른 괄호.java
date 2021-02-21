
import java.util.*;

public class Main {
    public static void main(String[] args){
        String s = 	"()()";
        boolean answer=true; 
        int cnt=0;
        Stack<Character> stack = new Stack<Character>();
        while(cnt<s.length()){
            if(s.charAt(cnt)=='('){
                stack.push('(');
                cnt++;
            }
            else if(s.charAt(cnt)==')'){
                if(stack.empty()){
                    answer=false;
                    break;
                }
                else if(stack.pop()!='('){
                    answer=false;
                    break;
                }
                cnt
            }
        }

    }
      
}
