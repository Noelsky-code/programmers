import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        String temp[] = s.split(" ");
        //int[] arr = new int[temp.length];
        for(int i=0;i<temp.length;i++){
            min=Math.min(Integer.parseInt(temp[i]),min);
            max=Math.max(Integer.parseInt(temp[i]),max);
        }
        answer=answer+min+" "+max;
        return answer;
    }
}