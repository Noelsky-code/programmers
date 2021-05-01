package src;

import java.util.*;

public class Main{
    static int g_board[][];
    static int size;
    public static void main(String[] args){

        int board[][]={{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        g_board=board;
        size=board.length;
        Queue<Robot> queue = new LinkedList<Robot>();
        queue.add(new Robot(0,0,1,0,0));
        HashSet<String> visit= new HashSet<String>();
        

        int answer=0;
        while(true){
            Robot poll = queue.poll();
            int x1=poll.col[0];
            int x2=poll.col[1];
            int y1=poll.row[0];
            int y2=poll.row[1];
            String add="";
            if((x1==size-1&&y1==size-1)||(x2==size-1&&y2==size-1)){//도착 했다면
                answer=poll.cnt;
                break;            
            }
            if(is_down(poll)){//내려갈 수 있다면 
                //queue.add(new Robot(x1,y1+1,x2,y2+1,poll.cnt+1));
                add=add+make_str(x1,y1+1,x2,y2+1);
                if(poll.get_dir()){//누워 있다면 
                    add=add+make_str(x1,y1,x1,y2+1);
                    add=add+make_str(x2,y2,x2,y2+1);
                }
            }
            if(is_up(poll)){//올라갈 수 있다면 
                add=add+make_str(x1,y1-1,x2,y2-1);
           
                if(poll.get_dir()){//누워 있다면 
                    add=add+make_str(x1,y1-1,x1,y1);
                    add=add+make_str(x2,y2-1,x2,y2);
                }
            }
            if(is_left(poll)){//왼쪽으로 이동할 수 있다면  
                add=add+make_str(x1-1,y1,x2-1,y2);
                if(!poll.get_dir()){//서 있다면 
                    add=add+make_str(x1-1,y1,x1,y1);
                    add=add+make_str(x2-1,y2,x2,y2);
                
                }
            }
            if(is_right(poll)){//오른쪽으로 이동할 수 있다면  
                add=add+make_str(x1+1,y1,x2+1,y2);
           
                if(!poll.get_dir()){//서 있다면 
                    add=add+make_str(x1,y1,x1+1,y1);
                    add=add+make_str(x2,y2,x2+1,y2);
                }
            }
            for(String s:add.split("\n")){
                if(!visit.contains(s)){
                    visit.add(s);
                    int cnt=0;
                    int[] a = new int[4];
                    for(String i:s.split(" ")){
                        a[cnt++]=Integer.parseInt(i);
                    }
                    queue.add(new Robot(a[0],a[1],a[2],a[3],poll.cnt+1));
                }
            }
            
        }
        System.out.println(answer);
    
    
    }
    static String make_str(int x1,int y1,int x2,int y2){
        return x1+" "+y1+" "+x2+" "+y2+"\n";
    }
    static boolean is_down(Robot robot){
        if(robot.row[1]==size-1)return false;
    
        if(robot.get_dir()){//누워 있다면 
            return (g_board[robot.row[0]+1][robot.col[0]]!=1)&&(g_board[robot.row[1]+1][robot.col[1]]!=1);
        }
        return g_board[robot.row[1]+1][robot.col[1]]!=1;//갈수있다면 true
    }
    static boolean is_up(Robot robot){
        if(robot.row[0]==0)return false;

    
        if(robot.get_dir()){//누워 있다면 
            return (g_board[robot.row[0]-1][robot.col[0]]!=1)&&(g_board[robot.row[1]-1][robot.col[1]]!=1);
        }
        return g_board[robot.row[0]-1][robot.col[0]]!=1;//갈수있다면 true
    }
    static boolean is_left(Robot robot){
        if(robot.col[0]==0)return false;
      
        if(!robot.get_dir()){//서 있다면 
            return (g_board[robot.row[0]][robot.col[0]-1]!=1)&&(g_board[robot.row[1]][robot.col[1]-1]!=1);
        }
        return g_board[robot.row[0]][robot.col[0]-1]!=1;//갈수있다면 true
    }
    static boolean is_right(Robot robot){
        if(robot.col[1]==size-1)return false;

        if(!robot.get_dir()){//서 있다면 
            return (g_board[robot.row[0]][robot.col[0]+1]!=1)&&(g_board[robot.row[1]][robot.col[1]+1]!=1);
        }
        return g_board[robot.row[1]][robot.col[1]+1]!=1;//갈수있다면 true
    }

}
class Robot{
    int row[];
    int col[];
    int cnt;
    public Robot(int x1,int y1,int x2,int y2,int cnt){
        this.row=new int[2];this.col=new int[2];
        this.row[0]=y1;this.row[1]=y2;this.col[0]=x1;this.col[1]=x2;
        this.cnt=cnt; 
    }

    public boolean get_dir(){
        return this.row[0]==this.row[1];//누워있다면 true, 세워있다면 false;
    }
}

/*
input :
[[0, 0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 1, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 1, 1], [0, 0, 1, 0, 0, 0, 0]]
result : 21

input : [[0, 0, 0, 0, 0, 0, 1], [1, 1, 1, 1, 0, 0, 1], [0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 0, 0], [0, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 1, 0], [0, 0, 1, 0, 0, 0, 0]]
result : 11

input: [[0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [0, 0, 1, 1, 1, 1, 1, 0, 0], [0, 1, 1, 1, 1, 1, 1, 1, 1], [0, 0, 1, 1, 1, 1, 1, 0, 0], [0, 0, 0, 0, 0, 0, 0, 0, 0], [1, 1, 1, 1, 1, 1, 1, 1, 0]]
result : 33

*/