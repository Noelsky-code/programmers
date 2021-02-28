
import java.util.*;

public class Main {
    
   
    public static void main(String[] args){
        int cacheSize=3;
        String[] cities={"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int answer=0;
        if(cacheSize==0){
            //return 5*cities.length;
        } 
        LinkedList<String> list= new LinkedList<String>();
        for(int i=0;i<cities.length;i++){
            String city= cities[i].toUpperCase();
            if(list.contains(city)){
                list.remove(city);
                list.addFirst(city);
                answer+=1;
            }
            else{
                if(list.size()==cacheSize){
                    list.removeLast();
                }
                list.addFirst(city);
                answer+=5;              
            }
        }

    }
    
}