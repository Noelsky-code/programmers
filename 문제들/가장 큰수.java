import java.util.*;

public class Main {
    
    public static void main(String[] args) {
   
        int[] numbers= {0,0,0,1000 };
        String[] number = new String[numbers.length];
        for(int i=0;i<numbers.length;i++){
            number[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(number,new Comparator<String>(){
            @Override
            public int compare(String a, String b){
               String temp_a="";
               String temp_b="";
               temp_a=a+b;
               temp_b=b+a;
               if(Integer.parseInt(temp_a)>Integer.parseInt(temp_b)){
                   return -1;
               }
               else if(Integer.parseInt(temp_a)<Integer.parseInt(temp_b)){
                   return 1;
               }

               return 0;

            }
        });
        for(String i:number)System.out.println(i);

    }
}