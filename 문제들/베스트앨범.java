import java.util.*;

public class Main {
     
    public static void main(String[] args) {

        String[] genres={"classic", "pop", "classic", "classic", "pop"};
        int[] plays={500, 600, 150, 800, 2500};
            
        HashMap<String,Integer> map= new HashMap<String,Integer>();
        HashMap<String,Integer> t_map= new HashMap<String,Integer>();
        PriorityQueue<Music> pq = new PriorityQueue<Music>();
        for(int i=0;i<genres.length;i++){
            map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
        }

        for(int i=0;i<genres.length;i++){
            pq.add(new Music(genres[i],map.get(genres[i]),plays[i],i));
        }
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i=0;i<genres.length;i++){
            Music temp = pq.poll();
            t_map.put(temp.g,t_map.getOrDefault(temp.g, 0)+1);
            if(t_map.get(temp.g)<=2){
                answer.add(temp.num);
            }
        }
        int[] ans= new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i]=answer.get(i);
        }

        
        
    }

}

class Music implements Comparable<Music>{
    String g;
    int genre;
    int play;
    int num;

    public Music(String g,int genre,int play,int num){
        this.g=g;
        this.genre=genre;
        this.play=play;
        this.num=num;
    }


    @Override
    public int compareTo(Music o) {
        if(Integer.compare(this.genre,o.genre)==0){
            if(Integer.compare(this.play,o.play)==0){
                return Integer.compare(this.num,o.num);
            }
            return -Integer.compare(this.play,o.play);
        }

        return -Integer.compare(this.genre,o.genre);       
    }

}