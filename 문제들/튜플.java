
import java.util.*;

public class Main {
    public static void main(String[] args){
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        s=s.substring(0,s.length()-2);//{제거}  {2},{2,1},{2,1,3},{2,1,3,4}
        s=s.replaceAll("\\{","");
        s=s.replaceAll("\\}"," ");
        
        //s=s.replaceAll(",", "");
        //System.out.println(s);
        String temp[] = s.split(" ,");
       
        
        Arrays.sort(temp,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                
                return Integer.compare(o1.length(),o2.length());
            }
        });
        //for(String a:temp)System.out.println(a);
        String[][] arr=new String[temp.length][];
        for(int i=0;i<temp.length;i++){
            arr[i]=temp[i].split(",");
        }
        
        
        int cnt=0;
        int[] answer=new int[arr.length];
        
        HashSet set = new HashSet<String>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(!set.contains(arr[i][j])){
                    set.add(arr[i][j]);
                    answer[cnt++]=Integer.parseInt(arr[i][j]);
                }
            }
        }
        System.out.println();

    }
      
}
