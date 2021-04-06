
import java.util.*;

public class Main{
   
   
    public static void main(String[] args){
        //시간 생각 x 
        String play_time="99:59:59";
        String adv_time="00:00:01";
        String[] logs={"99:59:58-99:59:59"};
        int play_time_ = get_time(play_time);
        int adv_time_=get_time(adv_time);
        HashMap<Integer,Integer> start_time = new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> end_time = new HashMap<Integer,Integer>();
        for(String s:logs){
            String[] temp= s.split("\\-");
            int start = get_time(temp[0]);
            int end = get_time(temp[1]);
            start_time.put(start,start_time.getOrDefault(start,0)+1);
            end_time.put(end,end_time.getOrDefault(end,0)+1);
        }// start와 end time을 맵에 넣어줌.
        
        long[] player = new long[play_time_+1];// 초당 palyer숫자 
        int cnt=0;

        for(int i=0;i<=play_time_;i++){
            cnt+=start_time.getOrDefault(i,0);
            cnt-=end_time.getOrDefault(i,0);
            player[i]=cnt;
           // cnt-=end_time.getOrDefault(i,0);
        }
        PriorityQueue<Adv> pq = new PriorityQueue<Adv>();
        long a=0;
        for(int i=0;i<adv_time_;i++){
            a+=player[i];
            pq.add(new Adv(a,0));
        }
        pq.add(new Adv(a,0));//0초에 얻을수 있는.. 
        int left=0;
        for(int i=adv_time_;i<play_time_;i++){
            a+=(player[i]-player[left++]);
            pq.add(new Adv(a,left));
        }
        int t=pq.poll().sec;
        System.out.println(String.format("%02d:%02d:%02d", t / (60 * 60), (t / 60) % 60, t % 60));
       // System.out.println(ret_time(pq.poll().sec));
        //System.out.println(pq.poll().player);
    
    }

    static int get_time(String time){
        String[] temp = time.split("\\:");
        
        return Integer.parseInt(temp[0])*60*60
        +Integer.parseInt(temp[1])*60
        +Integer.parseInt(temp[2]);
    }

    static String ret_time(int time){
        String ret="";
        String[] temp=new String[3];
        int cnt=2;
        while(cnt>=0){
            temp[cnt]=Integer.toString(time%60);//하아 ... 이거때문에 ..이거때문에...이거때문에...2시간넘게 잡아먹엇따...이거때문에...이거때문에...이거떄문에...............................
            if(temp[cnt].length()==1){
                temp[cnt] = "0"+temp[cnt];
            }
            time/=60;
            cnt--;
        }
        for(int i=0;i<3;i++){
            ret=ret+temp[i];
            if(i<2){
                ret=ret+":";
            }
        }
        return ret;
    }
}

class Adv implements Comparable<Adv>{
    long player;
    int sec;
    public Adv(long player,int sec){
        this.player=player;
        this.sec=sec;
    }
    @Override
    public int compareTo(Adv o) {
        if(Long.compare(this.player,o.player)==0){
            return Integer.compare(this.sec,o.sec);
        }
        // TODO Auto-generated method stub
        return -Long.compare(this.player,o.player);
    }

}