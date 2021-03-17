import java.util.*;

public class Main {
  
    public static void main(String[] args) {
        //n^2도 가능할듯 ? 
        //nlogn으로 짠듯 . sort시간만 .. 
        int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        Arrays.sort(routes,new Comparator<int[]>(){

            @Override
            public int compare(int[] o1, int[] o2) {
               
                if(o1[0]==o2[0])return -Integer.compare(o1[1],o2[1]);
                return Integer.compare(o1[0],o2[0]);
            }    
        });
        
        
        int answer=1;
        int left = routes[0][0];
        int right= routes[0][1];
        for(int i=1;i<routes.length;i++){
            if(routes[i][0]<=right){//범위가 겹친다면  범위를 줄여줌 
                left=routes[i][0];
                right=Math.min(right,routes[i][1]);// 더 좁은 범위로 줄여줌 
            }else{//범위에 포함되지 않는다면 
                left=routes[i][0];
                right=routes[i][1];
                answer++;//카메라 추가
            }
        }
       System.out.println(answer);
            
    }

}

