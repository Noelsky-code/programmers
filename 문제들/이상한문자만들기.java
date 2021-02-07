
import java.util.*;

public class Main {
    public static void main(String[] args){
     
        String s= "try hello world";
        String answer="";
        StringBuilder sb= new StringBuilder();

        int start=0;
        int end=0;
        char[] chars = s.toCharArray();
        int idx=0;
        for(int i=0;i<s.length();i++){
            if(chars[i]==' '){
                idx=0;
                sb.append(' ');
            }
            else{
                if(idx%2==0){
                    sb.append(Character.toUpperCase(chars[i]));
                }
                else{
                    sb.append(Character.toLowerCase(chars[i]));
                }
                idx++;
            }
        }
        
        System.out.println(sb.toString());
    }
}
