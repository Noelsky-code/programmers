import java.util.*;
//최대 2명만 탈수있다 ... 
class Solution {
    public int solution(int[] people, int limit) {
        
        int answer = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length-1;
        
    
        while(start<=end){
            int cnt=people[end--];
            if(cnt+people[start]<=limit){
                start++;
            }
            answer++;
                
        }
        return answer;

    }
}