import java.util.*;

/*
linkedlist의 탐색에 n ==> n^2 
--> arraylist 사용했으면 깔끔했을듯 (탐색 1,이경우 넣는것도 1 ); 
*/

public class Main {
    public static void main(String[] args) {
         int [] arr = {1,1,3,3,0,1,1};
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                list.addFirst(arr[i]);
            }
        }
        int[] answer=new int[list.size()];
        for(int i=list.size()-1;i>=0;i--){
            answer[i]=list.removeFirst();
        }

    }
}