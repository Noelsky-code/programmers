
import java.util.*;

public class Main {
  
    public static void main(String[] args) {
        // 우선순위 큐 ..? 좋을것 같은데 ? 
        int[][] jobs={{0, 3}, {1, 9}, {2, 6}};
        PriorityQueue<Job> pq = new PriorityQueue<Job>();
        Arrays.sort(jobs,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });//요청 시간순대로 
        int time=0;//time은 현재 시간 
        int cnt=0;
        int sum=0;
        while(cnt!=jobs.length||!pq.isEmpty()){//모든 job이 다 들어갈때까지  그리고 job이 다 끝날때까지
            if(cnt!=jobs.length){
            while(jobs[cnt][0]<=time){//해당 time에 들어오는 요청을 다 넣어줌 
                pq.add(new Job(jobs[cnt][0],jobs[cnt][1]));
                cnt++;
                if(cnt==jobs.length)break;
                }
            }
            if(pq.isEmpty()){//만약 비어있다면 다음 job 시간으로 점프
                time=jobs[cnt][0];//같은시간에 들어온게 여러개 있을수 있으므로 넣진 않는다.
            }
            else{//만약 비어있지 않다면 즉 대기 중인게 있다면 
                Job remove = pq.poll();//꺼내고 
                time+=remove.time;//time을 추가해주고
                sum+=time-remove.start;//기다린 시간을 추가 
            }
        }
        System.out.println(sum/cnt);
        
            
    }

}
class Job implements Comparable<Job>{

    int start;
    int time;
    public Job(int start,int time){
        this.start=start;
        this.time=time;
    }
    @Override
    public int compareTo(Job o) {
        return Integer.compare(this.time,o.time);
    }

}

