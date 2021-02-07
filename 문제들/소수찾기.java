import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean prime[]=  new boolean[n+1];
        Arrays.fill(prime,true);
        prime[0]=false;
        prime[1]=false;
        for(int i=2;i*i<=n;i++){
            if(prime[i]){//소수라면 제거 
            for(int j=i*i;j<=n;j+=i){//소수 다음수부터 제거
                prime[j]=false;
                
            }
            }
        }
        for(boolean i: prime){
            if(i)answer++;
        }
        return answer;
    }
}