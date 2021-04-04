import java.util.*;
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        boolean[][] is_bo = new boolean[n+3][n+3];
        boolean[][] is_ki = new boolean[n+3][n+3];
        
        PriorityQueue<A> pq = new PriorityQueue<A>();
        //frame에서 1은 기둥 , 2는 기둥+기둥 , 3은 보  ,4 보+기둥 6은 보 + 보 
        for(int i=0;i<build_frame.length;i++){
            int x= build_frame[i][0]+1;
            int y= build_frame[i][1]+1;
            int a = build_frame[i][2];//0=기둥 , 1= 보
            int b= build_frame[i][3];// 0=삭제, 1= 설치
            if(b==0){
                if(a==0){
                    is_ki[x][y]=false;
                    if(!can_delete(is_bo,is_ki,x,y,a)){
                        is_ki[x][y]=true;//불가능하다면 
                    }
                   
                    
                }
                else{
                    is_bo[x][y]=false;
                    if(!can_delete(is_bo,is_ki,x,y,a)){
                        is_bo[x][y]=true;//불가능하다면 
                    }
                   
                }
            
            }
            if(b==1&&can_install(is_bo,is_ki,x,y,a)){
                if(a==0){
                    is_ki[x][y]=true;
                }
                else if(a==1){
                    is_bo[x][y]=true;
                }
            }
        
        }
        for(int i=1;i<=n+1;i++){
            for(int j=1;j<=n+1;j++){
                if(is_bo[i][j]){
                    pq.add(new A(i,j,1));
                }
                if(is_ki[i][j]){
                    pq.add(new A(i,j,0));
                }
            }
        }
        int len= pq.size();
        int[][] answer = new int[len][3];
        for(int i=0;i<len;i++){
            A temp = pq.poll();
            answer[i][0]=temp.x-1;
            answer[i][1]=temp.y-1;
            answer[i][2]=temp.kind;
        }
        return answer;
        

        
    }
    static boolean can_install(boolean[][] is_bo,boolean[][] is_ki,int x,int y, int a){
        
        if(a==0){//기둥인 경우 
            return y==1||is_ki[x][y-1]||is_bo[x-1][y]||is_bo[x][y];
        }
        return is_ki[x][y-1]||is_ki[x+1][y-1]||(is_bo[x-1][y]&&is_bo[x+1][y]);
        
        
    }
    static boolean can_delete(boolean[][] is_bo,boolean[][] is_ki,int x,int y, int a){
        /*if(a==0){//기둥인 경우
            return ((is_ki[x][y+1]&&!can_install(is_bo,is_ki,x,y+1,0))
            ||(is_bo[x][y+1]&&can_install(is_bo,is_ki,x,y+1,1))
            ||(is_bo[x-1][y+1]&&can_install(is_bo,is_ki,x-1,y+1,1)));// 만약 삭제가 안되는 경우 false를 리턴
        }
        return ((is_ki[x][y]&&!can_install(is_bo,is_ki,x,y,0))||
        (is_ki[x+1][y]&&!can_install(is_bo,is_ki,x+1,y,0))||
        (is_bo[x+1][y]&&!can_install(is_bo,is_ki,x+1,y,1))||
        (is_bo[x-1][y]&&!can_install(is_bo,is_ki,x-1,y,1)));*/
        int n= is_bo.length;
        for(int i=1;i<n-1;i++){
            for(int j=1;j<n-1;j++){
                if(is_bo[i][j]&&!can_install(is_bo, is_ki, i, j, 1)){
                    return false;
                }
                if(is_ki[i][j]&&!can_install(is_bo, is_ki, i, j, 0)){
                    return false;
                }
            }
        }
        return true;
    }
}
class A implements Comparable<A>{
    int x;
    int y;
    int kind;
    public A(int x,int y,int kind){
        this.x=x;
        this.y=y;
        this.kind=kind;
    }
    @Override
    public int compareTo(A o) {
        if(Integer.compare(this.x,o.x)==0){
            if(Integer.compare(this.y,o.y)==0){
                return Integer.compare(this.kind,o.kind);
            }
            return Integer.compare(this.y,o.y);
        }
        // TODO Auto-generated method stub
        return Integer.compare(this.x,o.x);
    }
}