import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //무조건 answer는 한명 (참가-1 = 완주 )
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int len = participant.length;
        for(int i=0;i<len;i++){
            map.put(participant[i],0);
        }
        for(int i=0;i<len;i++){
            map.put(participant[i],map.get(participant[i])+1);
        }
        for(int i=0;i<len-1;i++){
            map.put(completion[i],map.get(completion[i])-1);
        }
        for(String i:map.keySet()){
            int t = map.get(i);
            if(t==1){
                answer=i;
                break;
            }
        }
        
        return answer;
    }
}