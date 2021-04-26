import java.util.*;

public class Main{
    static int board_global[][];
    static int check=0;
    static int before_r;
    static int before_c;
    static HashSet<String> per;
    static HashSet<Integer> set;

    static Point[] points;
    public static void main(String[] args){
        
        int[][] board={{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r=1;int c=0;
        
        board_global = board;
        before_r=0;
        before_c=0;
        per = new HashSet<String>();
        set = new HashSet<Integer>();    
        boolean[] visit = new boolean[7];
        make_set();//존재하는 카드 종류를 set에 넣음
        points = new Point[set.size()*2];

        points[0]=new Point(r,c,0);
        make_points();
        make_per(visit,"");//카드 순열을 만들어 per에 넣어줌
        for(String s:per){//1,2   3,4  5,6 
            
        }
       
       
    
    }
    public static void check(){
        
    }

    /*public static void make_arr(){
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int max= Math.abs(points[i].x-points[j].x)+ Math.abs(points[i].y-points[j].y);
                arr[i][j]=find_dist(points[i],points[j],max,0);
            }
        }
    }*/
    public static int find_dist(Point from,Point to,int max,int cnt){//목표 지점 찾는 과정 
        int ret = Math.abs(from.x-to.x)+ Math.abs(from.y-to.y);
        if(from.x==to.x&&from.y==to.y){
            return 0;
        }
        
        if(cnt>=max){
            return 987654321;
        }
        
        for(int i=0;i<4;i++){
            int[] next = ctrl(i,from.x,from.y);
            ret=Math.min(ret,1+find_dist(new Point(next[0],next[1],-1),to,max,cnt+1));
        }
        return ret;
        
    }
    public static void make_points(){
        int cnt=0;
        for(int i:set){
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(board_global[j][k]==i){
                        points[cnt++]= new Point(j,k,i);
                    }
                }
            }
        }
    }

    public static void make_set(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board_global[i][j]!=0){
                    set.add(board_global[i][j]);
                }
            }
        }
    }
    public static void make_per(boolean[] visit,String s){
        boolean pass = true;
        for(int i:set){
            if(!visit[i]){
                visit[i]=true;
                make_per(visit,s+Integer.toString(i));
                pass=false;
                visit[i]=false;
            }
        }
        if(pass){
            per.add(s);
            return;
        }
        
    } 
    public static int[] ctrl(int n,int r,int c){
        if(n==0){
            return ctrl_up(r, c);
        }
        if(n==1){
            return ctrl_down(r, c);
        }
        if(n==2){
            return ctrl_left(r, c);
        }
        return ctrl_right(r, c);
    }
    public static int[] ctrl_up(int r,int c){
        
        while(r!=0&&board_global[r][c]!=0){
            r=r-1;  
        }
        int out[] ={r,c};
        return out;
        
    }
    public static int[] ctrl_down(int r,int c){
        while(r!=board_global.length-1&&board_global[r][c]!=0){
            r=r+1;  
        }
        int out[] ={r,c};
        return out;
    }
    public static int[] ctrl_left(int r,int c){
        while(c!=0&&board_global[r][c]!=0){
            c=c-1;  
        }
        int out[] ={r,c};
        return out;
    }
    public static int[] ctrl_right(int r,int c){
        while(c!=board_global[0].length-1&&board_global[r][c]!=0){
            c=c+1;  
        }
        int out[] ={r,c};
        return out;
    }
}
class Point{
    int x;
    int y;
    int n;
    public  Point(int x,int y, int n ){
        this.x=x;
        this.y=y;
        this.n=n;
    }
}