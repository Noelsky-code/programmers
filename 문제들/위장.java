import java.util.*;
class Solution {
 
    public int solution(String[][] clothes) {
                
        int answer=1;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int cnt=0;
        for(int i=0;i<clothes.length;i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1],cnt);
                cnt++;
            }
            
        }
       int[] arr=new int[map.size()+1];
        
        for(int i=0;i<clothes.length;i++){
            arr[map.get(clothes[i][1])+1]++;
        }
        for(int i:arr)answer*=i+1;
        answer--;
        return answer;
        
    }
}