
import java.util.*;

public class Main {
    public static void main(String[] args){
        String new_id = "";
        String answer = "";
        new_id=new_id.toLowerCase();

        for(int i=0;i<new_id.length();i++){
            char a = new_id.charAt(i);
            if(a=='-'||a=='_'||a=='.'||(a>='0'&&a<='9')||((a>='a')&&(a<='z'))){

            }
            else{
                new_id=new_id.replace(a, ' ');
            }
        }
        new_id=new_id.replaceAll(" ", "");
        
        /*while(new_id.contains("..")){
            new_id=new_id.replaceAll("..", ".");
        }*/
        int cnt=0;
        String[] s = new_id.split("");
       
        String temp="";
        for(int i=0;i<s.length;i++){
            if(s[i].equals(".")){
                if(cnt==0){
                    cnt++;
                    temp+=s[i];
                }

            }
            else{
                cnt=0;
                temp+=s[i];
            }
        }
        //3단계까지 완료 
        
        int len=temp.length();
        if(len==1&&temp.charAt(0)=='.'){
            temp="";
        }
        else if(len==0){

        }
        else if(len>1&&temp.charAt(0)=='.'){
            temp=temp.substring(1);
        }
        len=temp.length();
        if(len==1&&temp.charAt(0)=='.'){
            temp="";
        }
        else if(len==0){

        }
        else if(len>1&&temp.charAt(len-1)=='.'){
            temp=temp.substring(0,len-1);
        }//4단계

        if(temp.length()==0){//5단계
            temp+="a";
        }
        if(temp.length()>15){
            if(temp.charAt(14)=='.'){
                temp=temp.substring(0, 14);
            }
            else{
                temp=temp.substring(0, 15);
            }
        }
        
        while(temp.length()<3){
            int l=temp.length();
            temp+=Character.toString(temp.charAt(l-1));
        }
        answer=temp;
        System.out.println(answer);

        
    }
}
