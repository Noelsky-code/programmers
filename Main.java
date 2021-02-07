import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"sun","bed","car"};
        int n= 1;
        Arrays.sort(strings, new Comparator<String>(){

            @Override
            public int compare(String a,String b){
                S
                return Character.compare(a.charAt(n), b.charAt(n));
                
            }
        });
        for(String s: strings){
            System.out.println(s);
        }
    }
}
