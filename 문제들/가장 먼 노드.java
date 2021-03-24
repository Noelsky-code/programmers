
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
        int n=6; 
        int[][] edge={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        ArrayList<Integer>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<edge.length;i++){
            int from= edge[i][0]-1;
            int to= edge[i][1]-1;
            list[to].add(from);
            list[from].add(to);
        }
        Queue<Integer> queue_now = new LinkedList<Integer>();
        Queue<Integer> queue_next= new LinkedList<Integer>();
        boolean[] visit= new boolean[n];
        Arrays.fill(visit,false);
        //bfs ㄱㄱ

        queue_now.add(0);
        visit[0]=true;
        int cnt=0;
        while(true){
            while(!queue_now.isEmpty()){
                int a= queue_now.poll();
                cnt++;
                for(int i:list[a]){
                    if(!visit[i]){
                        visit[i]=true;
                        queue_next.add(i);
                       
                    }
                }
            }
            if(queue_next.isEmpty()){
                break;
            }
            cnt=0;
            while(!queue_next.isEmpty()){
                queue_now.add(queue_next.poll());
            }
            
        }
        System.out.println(cnt);
    }
}