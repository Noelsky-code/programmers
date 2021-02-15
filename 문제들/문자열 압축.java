import java.util.*;
class Solution {
    public int solution(String s) {
        int n=1;
        int answer = s.length();
        int len= s.length();
        while(n<=len/2){
            
            /*if(len%n!=0){//나누어 떨어지지 않는다면 
                n++;
                continue;//다음으로 이동 
            }*/
            int ret=0;

            String[] temp = new String[(len/n)];
            int cnt=0;
            for(int i=0;cnt<(len/n);i+=n){
                temp[cnt++]=s.substring(i, i+n);//cnt에 배당완료 
                 //System.out.println(temp[cnt-1]);
            }
            cnt=1;//동일한거 카운트하기 
            Stack<String> stack = new Stack<String>();
            stack.push(temp[0]);
            for(int i=1;i<(len/n);i++){
                if(temp[i].equals(stack.peek())){
                   cnt++;     
                }
                else{
                    ret+=n;
                    if(cnt>1){
                        while(cnt!=0){
                            cnt/=10;
                            ret++;
                        }
                        
                        cnt=1;
                    }
                    stack.pop();
                    stack.push(temp[i]);
                }
            }
            if(cnt>1){
                 while(cnt!=0){
                            cnt/=10;
                            ret++;
                        }
            }
            ret+=n;
            if(len%n!=0){//자르고 남는부분 
                ret+=len%n;
            }
            answer=Math.min(answer,ret);
           // System.out.println();
            
            n++;
        }
        return answer;
        //System.out.println(answer);

    }
}