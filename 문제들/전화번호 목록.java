
import java.util.*;

public class Main {
    public static void main(String[] args){
        boolean answer=true;
        String[] phone_book = {"4321","432"};
        //log n
    
        int min=21;
        int max=0; 
        
        boolean[] len = new boolean[21];
        Arrays.fill(len,false);
        
        for(String s:phone_book){
            min=Math.min(s.length(),min);//가장 작은길이     
            max=Math.max(s.length(),max);//가장 긴 길이
            len[s.length()]=true;
        }
        
        for(int i=min;i<=max;i++){//최대 2천만
            if(!len[i])continue;
            HashSet<String> set = new HashSet<String>();//길이 맞는거 담을거 
            HashSet<String> temp = new HashSet<String>();// 자른거 담을거 
            for(String s:phone_book){
                if(s.length()>i){
                    temp.add(s.substring(0,i));
                    if(set.contains(s.substring(0,i))){
                        answer=false;
                        break;
                    }
                }
                else if(s.length()==i){
                    set.add(s.substring(0, i));
                    if(temp.contains(s.substring(0,i))){
                        answer=false;
                        break;
                    }
                }
            }
            if(!answer)break;
        }
        System.out.println(answer);
    }
}