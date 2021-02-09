class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int arr[] = new int[progresses.length];
        int now =0;
        int cnt=0;
        while(true){
            int ret=0;
            for(int i=0;i<progresses.length;i++){
                progresses[i]+=speeds[i];    
            }
            while(progresses[now]>=100){
                now++;
                ret++;
                if(now==progresses.length){
                    break;
                }
            }
            if(ret>0){
                arr[cnt++]=ret;
            }
             if(now==progresses.length){
                    break;
                }
        }
        int[] answer=new int[cnt];
        for(int i=0;i<cnt;i++){
            answer[i]=arr[i];
        }
        return answer;
    }
}