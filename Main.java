
import java.util.*;

public class Main {
    public static void main(String[] args){
        String[] seoul = {"Jane","Kim"};

        StringBuilder sb= new StringBuilder();
        int cnt=0;
        for(String i : seoul){
            
            if(i.equals("Kim")){
                break;                
            }
            cnt++;
        }
        sb.append("김서방은 ");
        sb.append(cnt);
        sb.append("에 있다");
        System.out.println(sb.toString());
    }
}
