class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int all=brown+yellow;//전체 타일갯수 
        for(int i=3;;i++){//가로
            int j=all/i;//세로
            if(all%i!=0)continue;
            int temp = 2*i+2*(j-2);
            if(temp==brown){
                answer[0]=Math.max(i,j);
                answer[1]=Math.min(i,j);
                break;
            }
        }
       return answer;

    }
}