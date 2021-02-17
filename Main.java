import java.util.*;

public class Main {
    static HashSet<Integer> set;
    static int max;
    public static void main(String[] args) {
        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        int[] arr= new int[orders.length];
        for(int i=0;i<orders.length;i++){
            int n=1;
            for(int j=0;j<orders[i].length();j++){
                n=n|(1<<(orders[i].charAt(j)-'A')+1);
            }
            arr[i]=n;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i:course){
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            set= new HashSet<Integer>();
            if(i==4){
                System.out.println(1);
            }
            for(int j=0;j<orders.length;j++){
                req(i,0,orders[j],1);
            }//set에 수열 넣기
            
           
            max=0;
            for(int j:set){
                int n=0;
                for(int k=0;k<arr.length;k++){
                    if((arr[k]&j)==j){
                        n++;
                    }
                }
                max=Math.max(max,n);
                map.put(j,n);
            }
            for(int j:set){
                if(map.get(j)==max&&max>=2){
                    list.add(j);//리스트에 값들이 담김 
                }
            } 
            
            //System.out.println(max);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        //Arrays.sort(ans);
        //for(int i:ans)System.out.println(i);
        
        String[] answer= new String[list.size()];
        for(int i=0;i<list.size();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=1;j<=26;j++){
                if((ans[i]&(1<<j))!=0){
                    sb.append((char)('A'+j-1));
                }
            }
            answer[i]=sb.toString();
        }
        Arrays.sort(answer);
        
       
        //HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
    }
    static void req(int n ,int cnt,String in,int have){
        if(cnt==n){
            set.add(have);
            return;
        }
        for(int i=0;i<in.length();i++){
            if((1<<((in.charAt(i)-'A')+1)&have)==0){//포함하고 있지 않다면 
                req(n,cnt+1,in,have|(1<<((in.charAt(i)-'A')+1)));
            }
        }

    }
}