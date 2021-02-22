import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:nums)map.put(i,0);
        if(map.size()>=(nums.length+1)/2){
            answer=(nums.length+1)/2;}
        else{
            answer=map.size();
        }
        
        return answer;
    }
}