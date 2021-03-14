import java.util.*;

class Solution {
    static LinkedList<Integer> list[];
    public int solution(int n, int[][] computers) {
        list = new LinkedList[computers.length];
        for(int i=0;i<computers.length;i++){
            list[i]=new LinkedList<Integer>();
            for(int j=0;j<computers.length;j++){
                if(i==j)continue;
                if(computers[i][j]==1){
                    list[i].add(j);
                }
            }
        }

        boolean visit[] = new boolean[computers.length];
        int answer=0;
        Arrays.fill(visit,false);
        for(int i=0;i<computers.length;i++){
            if(!visit[i]){
                answer++;
                network(i,visit);
            }
        }
        return answer;

    }
    static void network(int num,boolean[] visit){
        visit[num]=true;
        for(int i:list[num]){
            if(!visit[i]){
                network(i,visit);
            }
        }
    }

}