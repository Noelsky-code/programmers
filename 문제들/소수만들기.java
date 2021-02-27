
import java.util.*;

public class Main {
    static LinkedList<Integer>list;
    public static void main(String[] args){
       int[] nums={1,2,7,6,4};
       int[] numbers=new int[nums.length+1];
       int answer=0;
       for(int i=0;i<nums.length;i++){
            numbers[i+1]=nums[i];
       }
       list=new LinkedList<Integer>();
       combi(numbers,0,0,0);
       for(int i:list){
           if(is_prime(i))answer++;
       }
       System.out.println();
    }
    static void combi(int[] numbers,int num,int cnt,int now{
      
        if(cnt==3){
            list.add(num);
            return;

        }
        for(int i=now+1;i<numbers.length;i++){
           
                combi(numbers,num+numbers[i],cnt+1,i);
                

        }
        
    }
    static boolean is_prime(int num){
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}
