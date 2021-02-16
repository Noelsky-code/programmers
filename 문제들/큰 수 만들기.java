import java.util.*;
//다른사람들은 스택으로 풀었음 . 전체적인 로직은 비슷한듯? 
public class Main {
    //전체탐색시 시간 초과 -> 그리디로 
    public static void main(String[] args) {
        String number = "10";
        int k=1;
        System.out.println(get_max(number,k));
        //1.숫자 제일 큰거 구하기 
        //2-1. 왼쪽에 제거할거 갯수(a)가 k보다 작을시 제거 -> k-a
        //2-2 . 클경우 더 왼쪽으로 이동  
        //3-1. 제일 큰거 오른쪽에서 또 다시 .. 
    
    }
    static String get_max(String s,int n){//n= 더 지워야할 갯수 
        int len = s.length();
        if(len==0){//
            return "";
        }
        if(len==n){//지워야할게 자기자신이라면 
            return "";
        }
        if(n<=0){//더이상 지울게 없다면 
            return s;
        }
        int cnt=0;
        String ret="";
        boolean out = false; 
        for(int i=9;;i--){//큰수 서칭 
            cnt=0;
            for(int j=0;j<=n;j++){
                if(s.charAt(j)-'0'==i){
                    ret=Character.toString(s.charAt(j));
                    out=true;
                    break;
                }
                cnt++;
            }
            if(out){
                break;
            }
        }
        return ret+get_max(s.substring(cnt+1,len),n-cnt);
    }
    //21 
}