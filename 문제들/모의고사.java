
import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] answers = {1,3,2,4,2,6};

    //int len= answers.length;
       int  len=20;
      int[] a = new int[len];
      int[] b= new int[len];
      int[] c = new int[len];
      int cnt=1;
      for(int i=0;i<len;i++){
          a[i]=cnt++;
          if(cnt==6)cnt=1;
      }
      cnt=1;
      for(int i=0;i<len;i++){
          if(i%2==0){
              b[i]=2;
          }
          else{
              b[i]=cnt++;
              if(cnt==2)cnt++;
              if(cnt==6)cnt=1;
          }
      }
      cnt=0;
      int temp[]={3,1,2,4,5};
      for(int i=0;i<len;i++){  
        int idx= cnt/2;
        c[i]=temp[idx];
        cnt++;
        if(cnt==10){
            cnt=0;
        }
         
      }
     //for(int i:c)System.out.println(i);
      int max=0;
      int ex[]=new int[3];
      for(int i=0;i<len;i++){
          int p = answers[i];
          if(a[i]==p){
              ex[0]++;
          }
        if(b[i]==p){
              ex[1]++;
          }
          if(c[i]==p){
              ex[2]++;
          }
      }
      
      for(int i:ex){
        //System.out.println(i);
        //max=Math.max(max,i);
      }
      //System.out.println(max);
      //int[] answer={};
      LinkedList<Integer> list = new LinkedList<Integer>();
      for(int i=0;i<3;i++){
          if(ex[i]==max){
              list.add(i+1);
          }
      }
      
      int[] answer = new int[list.size()];
      for(int i=0;i<list.size();i++){
          answer[i]=list.get(i);
      }

      
    


  

        
    }
}
