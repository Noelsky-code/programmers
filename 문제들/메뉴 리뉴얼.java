import java.util.*;

public class Main {
    //
    public static void main(String[] args) {
        String[] orders={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        int[] arr= new int[orders.length];
        for(int i=0;i<orders.length;i++){
            int n=1;
            for(int j=0;j<orders[i].length();i++){
                n=n|(1<<orders[i].charAt(j)-'A')+1;
            }
            arr[i]=n;
        }
        /*int[] alphabet = new int[26];
        for(int i:course){





        }*/
       
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    }
}