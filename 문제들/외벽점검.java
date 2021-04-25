package src;

import java.util.*;

public class Main{
    static HashSet<String> per_dist;
    static int answer;
    public static void main(String[] args) {
        
        int n=12;
        int weak[] = {1,3,4,9,10};
        int dist[] = {3,5,7};
        
        answer=100;//초기값 100
        per_dist = new HashSet<String>();
        boolean[] visit= new boolean[dist.length];
        Arrays.fill(visit,false);
        make_per_dist(0,dist,visit,"");// 경우의 수 모두 만들어줌 
        

        LinkedList<Integer> list_weak = new LinkedList<Integer>();
        for(int i:weak){
            list_weak.addLast(i);//빼고 넣고 하기 쉽게하기위해 리스트에 넣어줌. 
        }

        
        for(int i=0;i<weak.length;i++){//하나씩 밀어주면서 검사함. 
            for(String s:per_dist){//모든 경우의수에 대해 체크
                LinkedList<Integer> temp = new LinkedList<Integer>();
                temp.addAll(list_weak);
                check(0,temp,s.split(" "));
            }
            //밀어주고 다음 점에서 다시시작.
            list_weak.addLast(list_weak.pollFirst()+n);
            
        }
        if(answer==100){
            //return -1;
        }   
        System.out.println(answer);
       // return answer;

    }
    static void make_per_dist(int cnt,int[] dist,boolean visit[],String out){
        if(cnt==dist.length){
            per_dist.add(out);
            return;
        }
        for(int i=0;i<dist.length;i++){
            if(!visit[i]){
                visit[i]=true;
                make_per_dist(cnt+1,dist,visit,out+Integer.toString(dist[i])+" ");
                visit[i]=false;
            }
        
        }
    }
    static void check(int cnt,LinkedList<Integer> temp,String[] s){
       
        if(temp.size()==0){
            answer=Math.min(answer,cnt);
            return;
        }
        if(cnt==s.length){
            return;
        }
        int max= Integer.parseInt(s[cnt])+temp.peekFirst();
        //System.out.println(max);
        int poll=temp.peekFirst();
        while(max>=poll){
            temp.pollFirst();
            if(temp.size()==0){
                break;
            }
            poll=temp.peekFirst();
        }
        check(cnt+1,temp,s);
    }
}