import java.util.*;

class Solution {
    public String solution(String s) {
         char[] chars = new char[s.length()];
        chars=s.toCharArray();
        Arrays.sort(chars);
        StringBuffer sb=  new StringBuffer();
        for(char c:chars){
            sb.append(c);
        }
        
        return sb.reverse().toString();
    }
}
