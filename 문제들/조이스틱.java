import java.util.*;

public class Main {
    static int arr[];
    static int min;
    public static void main(String[] args) {
        int answer=0;
        String name ="JAN";
        String temp="";
        min=Integer.MAX_VALUE;
        arr=new int[name.length()];
        for(int i=0;i<name.length();i++){
            arr[i]=Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);
            temp=temp+"A";
        }
        if(name.length()==1){
            answer = arr[0];
        }
        else{
            stick(name,temp,0,0,true);
            stick(name,temp,0,0,false);
        }
        //System.out.println((3+name.length())%name.length());
        System.out.println(min);
     
    }
    static void stick(String name,String temp,int n,int cnt,boolean left){//n은 현재위치 
        //현재위치의 글자 바꿔줌 
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<temp.length();i++){
            if(i==n){
               sb.append(name.charAt(i));
               cnt+=arr[i];
            }   
            else{
                sb.append(temp.charAt(i));
            }
        }
        temp=sb.toString();
        if(temp.equals(name)){
            min=Math.min(cnt,min);
            return;

        }
        if(left){//왼쪽으로 가고있는거라면 
        
            stick(name,temp,(n-1+name.length())%name.length(),cnt+1,true);
        }
        else{
            stick(name,temp,n+1,cnt+1,false);
            stick(name,temp,(n-1+name.length())%name.length(),cnt+1,true);
        }
        
        
    }
}