package src;

import java.util.*;

public class Main{
    static int board_global[][];
    static HashSet<String> per;
    static HashSet<Integer> set;
    static int count;
    

    static Point[] points;
    public static void main(String[] args){
        count=0;
        int[][] board={{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        int r=1;int c=0;
        
        board_global = board;
        per = new HashSet<String>();
        set = new HashSet<Integer>();    
        boolean[] visit = new boolean[7];
        make_set();//존재하는 카드 종류를 set에 넣음
        points = new Point[set.size()*2+1];

        points[0]=new Point(r,c,0);
        make_points();
        make_per(visit,"");//카드 순열을 만들어 per에 넣어줌
       
        int answer= 987654321;
         for(String s:per){//1,2   3,4  5,6 
            answer=Math.min(answer,check(s,-1,-1,1));
        }
        
        System.out.println(answer+set.size()*2);
        System.out.println(count);
    }
    public static int check(String s,int now,int cnt,int visit){//cnt에 방문한 점 index. 
        int ret=987654321;
        if(now==s.length()-1){
            if(cnt%2==1){//1,3,5
                ret=find_dist(points[cnt],points[cnt+1],make_max(points[cnt], points[cnt+1]),0);
            }
            else{
                ret=find_dist(points[cnt],points[cnt-1],make_max(points[cnt], points[cnt-1]),0);
            }
            //System.out.println(ret);
            return ret;
        }
        int next = (s.charAt(now+1)-'0')*2;//만약 1이라면 1~2 2라면 3 
        
        if(now==-1){//0일때
            Point p = points[0];
            ret=Math.min(ret,check(s,now+1,next-1,visit|(1<<(next-1)))+find_dist(p,points[next-1],make_max(p, points[next-1]),0));
            ret=Math.min(ret,check(s,now+1,next,visit|(1<<next))+find_dist(p,points[next],make_max(p, points[next]),0));
            return ret;
        }//return 되니까 고려 x 
        int temp = (s.charAt(now)-'0')*2;// temp는 now *2 
        if((visit&(1<<(temp)))==(1<<temp)&&((visit&(1<<(temp-1)))==(1<<(temp-1)))){//두점 모두 방문한 상태면 다음으로 넘어감. 
            board_global[points[temp-1].x][points[temp-1].y] = 0;
            board_global[points[temp].x][points[temp].y]=0;
            ret=Math.min(ret,check(s,now+1,next-1,visit|(1<<(next-1)))+find_dist(points[cnt],points[next-1],make_max(points[cnt], points[next-1]),0));
            ret=Math.min(ret,check(s,now+1,next,visit|(1<<(next)))+find_dist(points[cnt],points[next],make_max(points[cnt], points[next]),0));
            board_global[points[temp-1].x][points[temp-1].y] = points[temp].n;
            board_global[points[temp].x][points[temp].y]=points[temp].n;
        }
        else{//둘중 한점만 방문

            if(cnt%2==1){//1,3,5
                ret=check(s,now,cnt+1,visit|(1<<(cnt+1)))+find_dist(points[cnt],points[cnt+1],make_max(points[cnt], points[cnt+1]),0);
            }
            else{
                ret=check(s,now,cnt-1,visit|(1<<(cnt-1)))+find_dist(points[cnt],points[cnt-1],make_max(points[cnt], points[cnt-1]),0);
            }

        }
        //System.out.println(ret);
        return ret;

    }

    /*public static void make_arr(){
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int max= Math.abs(points[i].x-points[j].x)+ Math.abs(points[i].y-points[j].y);
                arr[i][j]=find_dist(points[i],points[j],max,0);
            }
        }
    }*/
    public static int make_max(Point from,Point to){
        return Math.abs(from.x-to.x)+ Math.abs(from.y-to.y);
    }
    public static int find_dist(Point from,Point to,int max,int cnt){//거리계산 . 흠 ...  
        //여기 때문에 시간초과남. 개선해야하는데 흠 ... 
        //힌트 얻었다 .. bfs를 쓰면 되겠구나 ..하아 .. 왜 생각을 못했을까 ... 다른건 다 생각했는데 ㅠㅠ 
        int[][] move={{1,0},{-1,0},{0,1},{0,-1}};
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(from.x,from.y,0));
        while(!(queue.peek().x==to.x&&queue.peek().y==to.y)){
            Point p = queue.poll();
            for(int i=0;i<4;i++){
                int[] next = ctrl(i,p.x,p.y);
                queue.add(new Point(next[0],next[1],p.n+1));
            }
            for(int i=0;i<4;i++){
                int row = p.x+move[i][0];
                int col = p.y+move[i][1];
                if(row>=0&&row<board_global.length&&col>=0&&col<board_global[0].length){
                    queue.add(new Point(row,col,p.n+1));
                }
            }         
        }
        return queue.peek().n;
        
    }
    public static void make_points(){
        int cnt=1;
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
        
        while(r!=0){
            r=r-1;
            if(board_global[r][c]!=0)break;  
        }
        int out[] ={r,c};
        return out;
        
    }
    public static int[] ctrl_down(int r,int c){
        while(r!=board_global.length-1){
            r=r+1;
            if(board_global[r][c]!=0)break;    
        }
        int out[] ={r,c};
        return out;
    }
    public static int[] ctrl_left(int r,int c){
        while(c!=0){
            c=c-1;
            if(board_global[r][c]!=0)break;    
        }
        int out[] ={r,c};
        return out;
    }
    public static int[] ctrl_right(int r,int c){
        while(c!=board_global[0].length-1){
            c=c+1;  
            if(board_global[r][c]!=0)break;  
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