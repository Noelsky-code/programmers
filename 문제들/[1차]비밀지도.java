
import java.util.*;

public class Main {


    public static void main(String[] args){
     
        //겹침 => or 연산 비트 => 결과값 2진수 변환 ㄱ 
        //n은 길이 
        int n=6;
        int arr1[]=	{46, 33, 33 ,22, 31, 50};
        int arr2[]=	{27 ,56, 19, 14, 14, 10};

        int arr[]=new int[n];
        String[] answer= new String[n];
        
        for(int i=0;i<n;i++){
           StringBuilder sb = new StringBuilder();
            arr[i]=arr1[i]|arr2[i];
            int cnt=n-1;
            char temp[]=new char[n];
            while(arr[i]!=0){
                temp[cnt]=(arr[i]%2==0)?' ':'#';
                arr[i]/=2;
                cnt--;
            }
            for(int j=0;j<n;j++){
                sb.append(temp[j]);
            }
            answer[i]=sb.toString();
            answer[i].replaceAll("\u0000"," ");
        
        }
        for(String i:answer){
            System.out.println(i);
        }        
    }
}