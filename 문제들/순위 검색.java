import java.util.*;

public class Main {
    static String a="";
    public static void main(String[] args) {
        String[] info={"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query={"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        String[][] inf=new String[info.length][5];
        String[][] que=new String[query.length][5];
        
      
        for(int i=0;i<info.length;i++){
            inf[i] = info[i].split(" ");
        }
        for(int i=0;i<query.length;i++){
            query[i]=query[i].replaceAll("and", "");
            query[i]=query[i].replaceAll("  ", " ");
            que[i]=query[i].split(" ");
        }
        ArrayList[] arr=new ArrayList[24];

       // int size[]=new int[36];
        
       // ArrayList<Integer> list =new ArrayList<Integer>();
        
        HashMap<String,Integer> map =new HashMap<String,Integer>();
        int cnt=0;
        for(int i=0;i<inf.length;i++){//20만번 가능 
            StringBuilder sb= new StringBuilder();
            for(int j=0;j<4;j++){
                sb.append(inf[i][j]);
            }
            if(!map.containsKey(sb.toString())){
                arr[cnt]=new ArrayList<Integer>(); 
                map.put(sb.toString(),cnt++);
            }
            int n=map.get(sb.toString());
            arr[n].add(Integer.parseInt(inf[i][4]));
        }
        for(int i=0;i<cnt;i++){
            Collections.sort(arr[i]);
         }
        //-는 어떻게 처리하지???
        int[] answer= new int[que.length];
        for(int i=0;i<que.length;i++){//n logn ==> 이분탐색 
            make_s(que[i],0,"");
            String temp[]=a.split(" ");
            a="";
            for(int j=0;j<temp.length;j++){
                String t= temp[j];
                if(!map.containsKey(t)){
                    continue;
                }
                int idx= map.get(temp[j]);
                /*for(int k=0;k<size[idx];k++){
                    System.out.println(arr[idx][k]);
                }*/
                if(arr[idx].size()==0)continue;
                answer[i]+=arr[idx].size()-find(arr[idx],Integer.parseInt(que[i][4]),0,arr[idx].size()-1);//이분탐색 log n 

            }
        }
        for(int i:answer){
            System.out.println(i);
        }
       
    
    }
    static void make_s(String s[],int cnt,String temp){
        if(cnt>3){
            if(a.length()==0){
                a=temp+" ";
            }
            else{
                a=a+temp+" ";
            }
            return;
        }
        if(cnt==0&&s[0].equals("-")){
            make_s(s,cnt+1,temp+"java");
            make_s(s,cnt+1,temp+"cpp");
            make_s(s,cnt+1,temp+"python");
        }
        else if(cnt==1&&s[1].equals("-")){
            make_s(s,cnt+1,temp+"backend");
            make_s(s,cnt+1,temp+"frontend");
        }
        else if(cnt==2&&s[2].equals("-")){
            make_s(s,cnt+1,temp+"junior");
            make_s(s,cnt+1,temp+"senior");
        }
        else if(cnt==3&&s[3].equals("-")){
            make_s(s,cnt+1,temp+"chicken");
            make_s(s,cnt+1,temp+"pizza");
        }
        else{
            make_s(s,cnt+1,temp+s[cnt]);
        }
    }
    static int find(ArrayList<Integer> arr,int num,int left,int right){
        int mid=(left+right)/2;
        if(left>right)return left;
        if(left>arr.size())return right;
        if(arr.get(mid)>=num){
           return find(arr,num,left,mid-1); 
        }
        return find(arr,num,mid+1,right);
    }
}