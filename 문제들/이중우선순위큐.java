import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
               PriorityQueue<Integer> pq_low = new PriorityQueue<>();
        PriorityQueue<Integer> pq_high= new PriorityQueue<Integer>(Collections.reverseOrder());
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        
        int size=0;
        for(String op:operations){
            String[] s = op.split(" ");
            int data= Integer.parseInt(s[1]);
            if(s[0].equals("I")){
                pq_low.add(data);
                pq_high.add(data);
                size++;
            }
            else if(s[0].equals("D")){
                if(data==-1&&size!=0){
                    int t=pq_low.poll();
                    pq_high.remove(t);
                    size--;
                }
                else if(data==1&&size!=0){
                    int t=pq_high.poll();
                    pq_low.remove(t);
                    size--;
                }
            }
           
        }
        int[] answer=new int[2];
        if(size==0){
            answer[0]=0;
            answer[1]=0;
        }
        else {
            answer[0]=pq_high.poll();
            answer[1]=pq_low.poll();
        }
        return answer;
    }

}