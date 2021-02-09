
import java.util.*;

public class Main {


    public static void main(String[] args){
     
        int N=5;
        int[] stages=  {2, 1, 2, 6, 2, 4, 3, 3};
        double[] fail= new double[N+1];
        int[] player = new int[N+1];
        int[] clear = new int[N+1];
        for(int i:stages){
            if(i==N+1){
                for(int j=1;j<=N;j++)clear[j]++;
                continue;
            }
            player[i]++;
            for(int j=1;j<=i;j++){
                clear[j]++;
            }
        }
        for(int i=1;i<=N;i++){
            if(clear[i]==0){
                fail[i]=0;
                continue;
            }
            fail[i]=(double)player[i]/clear[i];
            //System.out.println(player[i]+" "+clear[i]+" "+fail[i]);
        }
        
        Sort[] sort=new Sort[N];
        for(int i=0;i<N;i++){
            sort[i]=new Sort(fail[i+1],i+1);
        }
        Arrays.sort(sort, new Comparator<Sort>(){
            @Override
            public int compare(Sort a,Sort b){
                if(Double.compare(b.fail,a.fail)==0){
                    return Integer.compare(a.idx, b.idx);
                }
                return Double.compare(b.fail, a.fail);
            }
        });
        for(Sort i:sort){
            System.out.println(i.idx);
        }
    }
}
class Sort{
    double fail;
    int idx;
    public Sort(double fail,int idx){
        this.fail=fail;
        this.idx=idx;
    }
}