import java.util.*;

public class Main {
    //전체탐색시 시간 초과 -> 그리디로 
    public static void main(String[] args) {
        String number = "4177252841";
        int k=4;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<number.length();i++){
            map.put(number.charAt(i)-'0', 0);
        }
        for(int i=0;i<number.length();i++){
            map.put(number.charAt(i)-'0',map.get(i)+1);
        }
        //1.숫자 제일 큰거 구하기 
        //2-1. 왼쪽에 제거할거 갯수(a)가 k보다 작을시 제거 -> k-a
        //2-2 . 클경우 더 왼쪽으로 이동  
        //3-1. 제일 큰거 오른쪽에서 또 다시 .. 
    }
       
}