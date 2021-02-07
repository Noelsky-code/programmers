import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        //String[] answer =new String[strings.length];
         Arrays.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String a,String b){
                if(a.charAt(n)==b.charAt(n)){
                    return a.compareTo(b);
                }
                return Character.compare(a.charAt(n), b.charAt(n));
                
            }
        });
        
        return strings;
    }
}