import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int cnt=0;
        int now=0;
        int len=words.length;
        LinkedList<String> list = new LinkedList<String>();
        HashSet<String> set = new HashSet<String>();
     
        for(int i=0;i<len;i++){
            if(i==0){
                list.addFirst(words[0]);
            }
            if(words[i].length()==1){
                cnt=i;
    
                break;
            }
            else if(words[i].charAt(0)!=list.getFirst().charAt(list.getFirst().length()-1)&&i!=0){
                cnt=i;
               
                break;
            }
            else if(set.contains(words[i])&&i!=0){
                cnt=i;
                break;
            }
            set.add(words[i]);
            if(i!=0){
                list.addFirst(words[i]);
            }
            cnt=i;
        }
        
        int[] answer={(cnt%n)+1,(cnt/n)+1};
        if(list.size()==len){
            answer[0]=0;answer[1]=0;
        }
        return answer;
    }
}