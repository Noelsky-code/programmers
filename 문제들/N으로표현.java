import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        int N= 5;
        //ans=Integer.MAX_VALUE;
        int number= 12;
        HashSet<Integer> set[]=new HashSet[9];
        int temp=0;
        set[0]=new HashSet<Integer>();
        for(int i=0;i<=8;i++){
            set[i]=new HashSet<Integer>();
            temp+=N*Math.pow(10,i-1);
            set[i].add(temp);
        }
        
        for(int i=2;i<=8;i++){
            for(int j=1;j<=i/2;j++){
               for(int k:set[j]){
                   for(int m:set[i-j]){
                       set[i].add(m-k);
                       set[i].add(k+m);
                       set[i].add(k*m);
                       if(k!=0){
                       set[i].add(m/k);
                       }
                   }

               }
            }
        }
        int answer=-1;
        for(int i=1;i<=8;i++){
            if(set[i].contains(number)){
                answer=i;
                break;
            }
        }
        System.out.println(answer);
           
    }

}