
import java.util.*;
//시간복잡도 생각안하고 구현 1단계 문제보다 더쉬운듯? 
public class Main {


    public static void main(String[] args){
        int[] priorities={2,1,3,2};
        int location=2;
        LinkedList<Text> list = new LinkedList<Text>();
        for(int i=0;i<priorities.length;i++){
            list.addLast(new Text(i,priorities[i]));
        }
        int answer=0;
        while(true){
            int max= get_max(list);//
            Text temp= list.removeFirst();
            if(temp.priority==max){
                answer++;
                if(temp.idx==location){
                    break;
                }
            }
            else{
                list.addLast(temp);
            }
        }
        System.out.println(answer);
    }
    static int get_max(LinkedList<Text> list){
        int max=0;
        for(int i=0;i<list.size();i++){
            max=Math.max(list.get(i).priority,max);
        }
        return max;
        
    }

}
class Text{
    int idx;
    int priority;
    public Text(int idx,int priority){
        this.idx=idx;
        this.priority=priority;
    }
}