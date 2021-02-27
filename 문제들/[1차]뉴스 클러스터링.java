import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
StringBuilder sb=new StringBuilder();
        
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        HashMap<String,Integer> map1=new HashMap<String,Integer>();
        HashMap<String,Integer> map2=new HashMap<String,Integer>();
        
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<str1.length()-1;i++){//map 1채우기 
            sb.setLength(0);//sb 비우기 
            char a = str1.charAt(i);
            char b= str1.charAt(i+1);
            if(a>='a'&&a<='z'){
                sb.append(a);
            }
            if(b>='a'&&b<='z'){
                sb.append(b);
            }
            String s= sb.toString();
            if(s.length()==2){
                if(map1.containsKey(s)){
                    map1.put(s,map1.get(s)+1);
                }
                else{
                    set.add(s);
                    map1.put(s,1);
                }
            }
        }
        for(int i=0;i<str2.length()-1;i++){//map2 채우기 
            sb.setLength(0);//sb 비우기 
            char a = str2.charAt(i);
            char b= str2.charAt(i+1);
            if(a>='a'&&a<='z'){
                sb.append(a);
            }
            if(b>='a'&&b<='z'){
                sb.append(b);
            }
            String s= sb.toString();
            if(s.length()==2){
                if(map2.containsKey(s)){
                    map2.put(s,map2.get(s)+1);
                }
                else{
                    set.add(s);
                    map2.put(s,1);
                }
            }
        }
        //set은 합 
        int max=0;//합집합
        int min=0;//교집합
        for(String s: set){
            if(map1.containsKey(s)&&map2.containsKey(s)){//교집합일떄 
                min+=Math.min(map1.get(s),map2.get(s));
                max+=Math.max(map1.get(s),map2.get(s));
            }
            else if(map1.containsKey(s)){
                max+=map1.get(s);
            }
            else{
                max+=map2.get(s);
            }
        }
        if(max==0)return 65536;
        double ans = ((double)min/max)*65536;
        int answer= (int)ans;
        
        return answer;
    }
}