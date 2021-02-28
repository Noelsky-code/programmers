
import java.util.*;

public class Main {
    
    static LinkedList<Integer> list;//가능한 조합 담은리스트 

    public static void main(String[] args){
        int answer=0;
        String[][] relation={{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        int row=relation.length;
        int col=relation[0].length;
        list =new LinkedList<Integer>(); 
        
        for(int i=1;i<=col;i++){//1개 부터 .. col 개 까지 
            make_combi(0,0,i,1,col);
        }
        LinkedList<Integer> minimal=new LinkedList<Integer>();

        for(int i:list){
            if(check_unique(relation,i)){//만약유일성이 있다면 
                if(check_minimal(i, minimal)){//최소성 까지 있다면 
                    answer++;
                }
            }
        }
        System.out.println();
        
    }
    static void make_combi(int now,int cnt,int num,int visit,int col){
        
        if(cnt==num){
        list.addLast(visit);
        return;
        }
         for(int i=now+1;i<=col;i++){
            make_combi(i,cnt+1,num,visit|(1<<i),col);
        }
    }
    static boolean check_unique(String[][] relation,int visit){
        LinkedList<Integer> visits= new LinkedList<Integer>();
        HashSet<String> set= new HashSet<String>();
        for(int i=1;i<=relation[0].length;i++){
            if((visit&(1<<i))==(1<<i)){//방문한곳이라면 
                visits.addLast(i-1);//col 위치 visits에 추가 
            }
        }
        for(int i=0;i<relation.length;i++){
            String temp="";
            for(int j:visits){
                temp=temp+relation[i][j];
            }
            if(set.contains(temp)){//유일성 꺠진다면 
                return false;
            }
            else{
                set.add(temp);
            }
        }
        return true;
    }
    static boolean check_minimal(int check,LinkedList<Integer> minimal){
        for(int i:minimal){
            if((check&i)==i){
                return false;
            }
        }
        minimal.addLast(check);
        return true;

    }

}