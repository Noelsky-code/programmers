import java.util.*;

public class Main {
    static HashSet<Integer> set;
    static int len;
    static String number;
    public static void main(String[] args) {
        String numbers="011";
        number=numbers;
        set = new HashSet<Integer>();
        len= numbers.length();

        //int n = (1<<(numbers.length()+1))-1;
        for(int i=1;i<=len;i++){
           get_num(i, 0, 1,"");
        }
    
        System.out.println(set.size());

    }
    static void prime(int n ){
        boolean flag=true;
        if(n==1||n==0){
            return;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                flag=false;
                break;
            }
        }
        if(flag){
            set.add(n);
        }
    }
    static void get_num(int n,int cnt,int have,String s){//n은 채워야할 길이,cnt는 갯수 have는 뽑은것 
        if(cnt==n){//다 채웠다면 
            System.out.println(s);
            prime(Integer.parseInt(s));
        }
        for(int i=1;i<=len;i++){
            if((have&1<<i)==0){//뽑은게 아니라면 
                get_num(n,cnt+1,(1<<i)|have,s+Character.toString(number.charAt(i-1)));     
            }
        }
    }
}