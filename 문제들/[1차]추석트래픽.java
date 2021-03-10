
import java.util.*;

public class Main {
    
    //문제 이해하는데 10분쓴듯 .... 
    //임의 시간~ 1초 , 데이터 정렬되어있음 ... , -0.001 해줘야함 . 
    //어뜩해야하지? 1000개의 데이터 . 
    //데이터 a 가 시작하고 끝날때까지 겹치는 최대 데이터량 . 계산 .. 근데 .. 1초 단위 ... 
    // 2000*3000 -> 최대 6000000 개의 밀리초의 데이터 나올수 있음 
    // 1000*1000에 대해 1초(1000) 씩의 탐색 -> 10^9 -> dp가능 
    //매 밀리초마다 겹치는 component들 , list에 추가  -> 1초단위로 끊어서 확인 ... 
    // dp 못쓸거같음 -> 데이터량 변화하는 시작점 , 끝점에서 1초씩 window 만들고 확인 
    public static void main(String[] args){
        String[] lines={"2016-09-15 20:59:57.421 0.351s",
        "2016-09-15 20:59:58.233 1.181s",
        "2016-09-15 20:59:58.299 0.8s",
        "2016-09-15 20:59:58.688 1.041s",
        "2016-09-15 20:59:59.591 1.412s",
        "2016-09-15 21:00:00.464 1.466s",
        "2016-09-15 21:00:00.741 1.581s",
        "2016-09-15 21:00:00.748 2.31s",
        "2016-09-15 21:00:00.966 0.381s",
        "2016-09-15 21:00:02.066 2.62s"
        };

        int[] start= new int[lines.length];
        int[] end= new int[lines.length];
        get_time(lines,start,end);//time을 다 get함 
        int answer=0;
        for(int i=0;i<lines.length;i++){//start 부터의 1초 
            int cnt=0;
            int start_time=start[i];
            int end_time=start_time+999;
            if(i==9){
                System.out.println();
            }
            for(int j=0;j<lines.length;j++){
                int t_start_time=start[j];
                int t_end_time=end[j];
                if(t_start_time>=start_time&&t_start_time<=end_time){//시작 시간이 1초안에 있다면 
                    cnt++;
                }
                else if(t_end_time>=start_time&&t_end_time<=end_time){//종료 시간이 1초 안에 있다면 
                    cnt++;
                }
                else if(t_start_time<=start_time&&end_time<=t_end_time){//시작,종료 시간이 1초 양 끝 밖에 있을경우 
                    cnt++;
                }
                
            }
            
        }
        
        
        for(int i=0;i<lines.length;i++){//end 부터의 1초 
            int cnt=0;
            int start_time=end[i];
            int end_time=start_time+999;
            for(int j=0;j<lines.length;j++){
                int t_start_time=start[j];
                int t_end_time=end[j];
                if(t_start_time>=start_time&&t_start_time<=end_time){//시작 시간이 1초안에 있다면 
                    cnt++;
                }
                else if(t_end_time>=start_time&&t_end_time<=end_time){//종료 시간이 1초 안에 있다면 
                    cnt++;
                }
                else if(t_start_time<=start_time&&end_time<=t_end_time){//시작,종료 시간이 1초 양 끝 밖에 있을경우 
                    cnt++;
                }
               
            }
           
            answer=Math.max(cnt,answer);
        }
        System.out.println(answer);
        

    }
    static void get_time(String[] lines, int[] start,int[] end){//전부 mili second로 변환
        for(int i=0;i<lines.length;i++){
            String[] temp = lines[i].split(" ");
            String[] s = temp[1].split(":");
            int hour=Integer.parseInt(s[0])*60*60*1000;
            int min= Integer.parseInt(s[1])*60*1000;
            int sec= Integer.parseInt(s[2].replaceAll("\\.",""));
            int e_time=hour+min+sec;
            int proceed=((int)(Double.parseDouble(temp[2].replaceAll("s",""))*1000));
            start[i]=e_time-proceed+1;
            end[i]=e_time;
          
        }
    }

}