
import java.util.*;

public class Main {
    
    
    public static void main(String[] args){
        String msg="TOBEORNOTTOBEORTOBEORNOT";
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1;i<=26;i++){
            char temp = (char)('A'+i-1);
            map.put(Character.toString(temp),i);
        }
        int cnt=27;
        int len=msg.length();
        for(int i=0;i<len;){
            String temp=msg.substring(i, i+1);
            
            while(map.containsKey(temp)){//맵에 없을때까지 
                i++;
                if(i==len){
                    break;
                }
                temp=temp+msg.substring(i,i+1);
            }
            if(i==len){
                list.addLast(map.get(temp));
                break;
            }
            list.add(map.get(temp.substring(0,temp.length()-1)));
            map.put(temp,cnt++);
            
        }
        int[] answer=new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        System.out.println();
    }

}