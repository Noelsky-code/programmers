
import java.util.*;

public class Main {
    static HashSet<Integer> set;//갈수 있는곳을 담을 set 
    static ArrayList<Road> list[];
    public static void main(String[] args){
        int N=5; int[][] road={{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}; int K =3;
        list=new ArrayList[N];
        boolean[] visit= new boolean[N];
        set=new HashSet<>();
        for(int i=0;i<N;i++){
            list[i]=new ArrayList<Road>();
            visit[i]=false;
        }  
        for(int i=0;i<road.length;i++){
            list[road[i][0]-1].add(new Road(road[i][1]-1,road[i][2]));
            list[road[i][1]-1].add(new Road(road[i][0]-1,road[i][2]));//양방향이므로 
        }
        set.add(0);//1번도시 추가 
        visit[0]=true;//1번도시는 항상 true
        for(Road i:list[0]){// 1번 마을에 있는 도로들 
           find(K,i.to,i.price,visit);
        }
        System.out.println();

    }
    static void find(int K,int now,int cnt,boolean[] visit){//now는 현재 도시 cnt는 누적 
        if(cnt>K){
            return;
        }
        //갈 수 있는 도시라면 
        set.add(now);
        visit[now]=true;
        for(Road i:list[now]){
            if(!visit[i.to]){
               find(K,i.to,cnt+i.price,visit); 
            }
        }
        visit[now]=false;//다시 풀어줌 

    }
}

class Road{
    int to;
    int price;
    public Road(int to,int price){
        this.to=to;
        this.price=price;
    }

}