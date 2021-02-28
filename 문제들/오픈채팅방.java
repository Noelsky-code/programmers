
import java.util.*;

public class Main {
    
    public static void main(String[] args){
        String[] record= {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        HashMap<String,String> map=new HashMap<String,String>();
        int cnt=0;
        for(String s:record){
            String[] in= s.split(" ");
            if(in[0].equals("Enter")){
                cnt++;
                map.put(in[1],in[2]);
            }
            else if(in[0].equals("Change")){
                map.put(in[1],in[2]);
            }
            else if(in[0].equals("Leave")){
                cnt++;
            }
        }
        String[] answer=new String[cnt];
        cnt=0;
        for(String s:record){
            String[] in= s.split(" ");
            if(in[0].equals("Enter")){
                answer[cnt++]=map.get(in[1])+"님이 들어왔습니다.";
            }
            else if(in[0].equals("Leave")){
                answer[cnt++]=map.get(in[1])+"님이 나갔습니다.";
            }
        }
        System.out.println();
    }
    
}