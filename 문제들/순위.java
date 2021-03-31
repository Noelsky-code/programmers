
import java.util.*;

public class Main{
   //시간 생각 x 
    public static void main(String[] args) {
        int n=5;
        int[][] results={{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        
        Player[] players=new Player[n+1];

        for(int i=1;i<=n;i++){
            players[i]=new Player(i);
        }
        for(int i=0;i<results.length;i++){
            int winner= results[i][0];
            int loser = results[i][1];
            players[winner].losers.add(loser);
            players[loser].winners.add(winner);
        }
        for(int depth=0;depth<n;depth++){//depth만큼 한층 한층 win,lose가 쌓임 
            for(int i=1;i<=n;i++){
                Player player = players[i];
                HashSet<Integer> winSet = new HashSet<>();//그냥 for문 돌리면 오류남 
                for(int winner:players[i].winners){
                    for(int win:players[winner].winners){
                        winSet.add(win);
                    }
                }
                player.winners.addAll(winSet);
                HashSet<Integer> loseSet = new HashSet<>();
                for(int loser:player.losers){
                    for(int lose:players[loser].losers){
                        loseSet.add(lose);
                    }
                }    
                player.losers.addAll(loseSet);          
            }
        }
        int answer=0;
        for(int i=1;i<=n;i++){
            if(players[i].winners.size()+players[i].losers.size()==n-1){
                answer++;
            }
           
        }
        System.out.println(answer);

        
    }
   /* static void find_winner(Player[] players,int now,int num){//now는 지금 탐색하는애 num은 찾는애 
        players[num].set.add(now);//winner에 넣어줌 
        players[num].win_visit[now]=true;
        if(players[now].winners.size()==0){
            return;
        }
        for(int i:players[now].winners){
            if(!players[num].win_visit[i]){
            find_winner(players,i,num);
            }
        }        

    }
    static void find_loser(Player[] players,int now,int num){//now는 지금 탐색하는애 num은 찾는애 
        players[num].set.add(now);//winner에 넣어줌 
        players[num].lose_visit[now]=true;
        if(players[now].losers.size()==0){
            return;
        }
        for(int i:players[now].losers){
            if(!players[num].win_visit[i]){
            find_loser(players,i,num);
            }
        }        

    }*/

}
class Player{

    HashSet<Integer> winners;
    HashSet<Integer> losers;
    int num;
    public Player(int num){
        this.winners=new HashSet<Integer>();
        this.losers= new HashSet<Integer>();
        this.num= num;
    }


}



