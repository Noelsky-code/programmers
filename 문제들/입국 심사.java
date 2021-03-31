
class Solution {
    public long solution(int n, int[] times) {

        long answer=0;
        long min=1;
        long max= 0;
        for(int i=0;i<times.length;i++){
            max=Math.max(max,times[i]);

        }
        max=max*n;
        answer=max;
        while(min<=max){
            long mid=(min+max)/2;
            long sum=0;
            for(int i=0;i<times.length;i++){
                sum+=mid/times[i];
            }
            if(sum>=n){
                answer=Math.min(answer,mid);
                max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return answer;
    }
}