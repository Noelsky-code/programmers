/*import java.util.*;
//테스트 1 〉	실패 (377.16ms, 91.2MB)
테스트 2 〉	실패 (491.70ms, 200MB)
테스트 3 〉	실패 (2061.91ms, 527MB)
테스트 4 〉	실패 (210.17ms, 84.5MB)
테스트 5 〉	실패 (2036.85ms, 461MB)
//
public class Main {
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        int answer=0;
        int[] scoville= {1,0,0};
        int k= 7;
        list=new ArrayList<Integer>();
        list.add(0);
        for(int i:scoville){
            insert(i);
        }
        
        while(true){//n 
            int min=delete();
            if(min>=k){
                break;
            }
            if(list.size()==1){
                answer=-1;
                break;
            }
            int del=delete();//log n 
            int ins = min+2*del;
            answer++;
            insert(ins);//log n 
        }
        System.out.println(answer);

    }
    static void insert(int n){
        int size = list.size();
        list.add(size,n);//마지막 index에 n삽입
        while(size!=1){
            if(list.get(size)<list.get(size/2)){
                int temp= list.get(size/2);
                list.set(size/2,list.get(size));
                list.set(size,temp);
            }
            else{
                break;
            }
        }
    }
    static int delete(){
        int ret= list.get(1);
        if(list.size()==2){
            return list.remove(1);
        }
        list.set(1,list.remove(list.size()-1));
        int n = 1;
        while(n*2<list.size()){
            int pos = n*2;
            int pos_item= list.get(pos);
            if(pos+1<list.size()){
                if(pos_item>list.get(pos+1)){
                    pos_item=list.get(pos+1);
                    pos++;
                }
            }
            if(list.get(n)<pos_item){
                break;
            }
            int temp= list.get(n);
            list.set(n,pos_item);
            list.set(pos,temp);
            n=pos;
        }
        return ret;
    }
}*/
import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int answer=0;
        int[] scoville= {1, 2, 3, 9, 10, 12};
        int K=7;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i:scoville)pq.add(i);
        while(true){
            int n= pq.poll();
            if(n>=K)break;
            if(pq.size()==0){
                answer=-1;
                break;
            }
            int m =pq.poll();
            pq.add(n+2*m);
            answer++;
        }
        System.out.println(answer);
    }
}