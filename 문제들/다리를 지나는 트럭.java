import java.util.*;

public class Main {
    public static void main(String[] args) {
        int bridge_length=2; int weight=10; int[] truck_weights={7,4,5,6};
        LinkedList<Truck> truck=new LinkedList<Truck>();

        int now=0;
        int time=0;
        int now_weight=0;
       // truck.addFirst(new Truck(0,truck_weights));
        while(true){
            time++;
            if(!truck.isEmpty()){
                if(time-truck.peekFirst().time==bridge_length){//트럭이 나올 수 있다면 
                    now_weight=now_weight-truck.removeFirst().weight;
                }
            }
            if(truck_weights[now]+now_weight<=weight){//더 넣을 수 있다면 
                truck.addLast(new Truck(truck_weights[now],time));//트럭을 넣는다 . 
                now_weight+=truck_weights[now];
                now++;//대기 순번 높이고 
                if(now==truck_weights.length){//마지막 트럭이 들어간다면 
                    time+=bridge_length;
                    break;
                }
            }
            
        }
        System.out.println(time);
    }
    
}
class Truck{
    int weight;
    int time;
    public Truck(int weight,int time){
        this.weight=weight;
        this.time=time;
    }
}