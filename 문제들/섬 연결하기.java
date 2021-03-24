
import java.util.*;

public class Main {
   
    public static void main(String[] args) {
        //시간 생각 x 
        // 가장 작은 costs 선택 => set에 넣고 ...priority queue만들자.
        //섬이 다 포함되어 있는지는 size로 판단하자 . 
        int[][] costs={{0,1,1},{0,2,2},{1,2,5},{1,3,3},{2,3,8},{3,4,1}};
        int n= 5;
        PriorityQueue<Bridge> bridges= new PriorityQueue<Bridge>();
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> get_size= new HashSet<Integer>();
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<costs.length;i++){
            int from=Math.min(costs[i][0],costs[i][1]);
            int to=Math.max(costs[i][0],costs[i][1]);
            int c= costs[i][2];
            get_size.add(from);
            get_size.add(to);
            bridges.add(new Bridge(from, to, c));
        }
        //if get_size 가 1이면 0리턴 
        int ans=0;
        int cnt=0;
        while(cnt!=get_size.size()){
            Bridge out = bridges.poll();
            cnt=0;
            int from=out.from;
            int to=out.to;
            if(parent[from]!=parent[to]){
                int temp= parent[from];
                for(int i=0;i<n;i++){
                    if(parent[i]==temp){
                        parent[i]=parent[to];
                        cnt++;
                    }
                    else if(parent[i]==parent[to]){
                        cnt++;
                    }
                }
                ans+=out.costs;
            }
        }
        
        System.out.println(ans);
    
    }
}


class Bridge implements Comparable<Bridge>{
    int from;
    int to;
    int costs;
    public Bridge(int from,int to,int costs){
        this.from=from;
        this.to=to;
        this.costs=costs;
    }
    @Override
    public int compareTo(Bridge o) {
        // TODO Auto-generated method stub
        return Integer.compare(this.costs,o.costs );
    }
}