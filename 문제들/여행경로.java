
import java.util.*;

public class Main{
   
    static ArrayList<String> answer;
    static ArrayList[] list;
    static HashMap<String,Integer> map;
    static int len;
    public static void main(String[] args) {
        String[][] tickets={{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        
        int cnt=0;
        len=tickets.length;
        answer= new ArrayList<String>();
        map = new HashMap<String,Integer>();
        for(int i=0;i<tickets.length;i++){
            if(!map.containsKey(tickets[i][0])){
                map.put(tickets[i][0],cnt++);
            }
            if(!map.containsKey(tickets[i][1])){
                map.put(tickets[i][1],cnt++);
            }
        }
        list= new ArrayList[map.size()];
        for(int i=0;i<map.size();i++){
            list[i]=new ArrayList<String>();
        }
        for(int i=0;i<tickets.length;i++){
            int from= map.get(tickets[i][0]);
            list[from].add(tickets[i][1]);
        }
        visit(0,map.get("ICN"),"ICN");
        Collections.sort(answer);
        System.out.println(answer.get(0));
        
    }
    static void visit(int cnt,int from,String in){
        if(cnt==len){
           answer.add(in);
            return;
        }
        for(int i=0;i<list[from].size();i++){
            String a=(String) list[from].remove(i);
            visit(cnt+1,map.get(a),in+" "+a);
            list[from].add(i,a);
        }
        return;
    }

}


