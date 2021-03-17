
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) {
        String begin="hit";
        String target="cog";
        answer=Integer.MAX_VALUE;
       
        String[] words={"hot", "dot", "dog", "lot", "log", "cog"};
     
        boolean[] visit= new boolean[words.length];
        for(int i=0;i<words.length;i++){
            transition(begin,target,words,0,visit);
        }
        System.out.println(answer);
    }

    static void transition(String begin,String target,String words[],int cnt,boolean[] visit){
        if(begin.equals(target)){
            answer=Math.min(cnt,answer);
            return;
        }
     
      
        
        for(int i=0;i<words.length;i++){
            int check=0;
            if(visit[i])continue;//방문한곳이면 통과 
            for(int j=0;j<words[i].length();j++){
                if(begin.charAt(j)!=words[i].charAt(j)){
                    check++;
                }
            }
            if(check==1){//갈수 있다면 
                visit[i]=true;
                transition(words[i],target,words,cnt+1,visit);
                visit[i]=false;//풀어줌
            }
        }
        
      

    }
}