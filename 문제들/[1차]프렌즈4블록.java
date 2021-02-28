
import java.util.*;

public class Main {
    //시간복잡도 신경 X 
    //1.카피한 배열 만들기
    //2.카피한 배열과 같은지 판단 .
    
   
    public static void main(String[] args){
        int m=4;
        int n=5;
        String[] board={"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] temp=new String[m];
        int ret=0;
        while(ret!=-1){
            ret=0;
            temp=make_arr(board);
            temp=remove(temp);
            for(int i=0;i<m;i++){
                if(!board[i].equals(temp[i])){
                    ret=1;
                    break;
                }
            }
            if(ret!=1){
                break;
            }
            board=temp;
        }
        int answer=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i].charAt(j)==' '){
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
    static String[] make_arr(String[] s){
        String[] copy= new String[s.length];
        int row=s.length;
        int col=s[0].length();
        int cnt=0;
        char[][] temp = new char[row][col];
        for(int i=0;i<row-1;i++){
            for(int j=0;j<col-1;j++){
                if(s[i].charAt(j)==s[i+1].charAt(j)&&s[i].charAt(j+1)==s[i+1].charAt(j+1)&&s[i+1].charAt(j+1)==s[i].charAt(j)){
                    temp[i][j]='.';
                    temp[i+1][j]='.';
                    temp[i][j+1]='.';
                    temp[i+1][j+1]='.';
                }
            }
        }
        for(int i=0;i<row;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<col;j++){
                if(temp[i][j]!='.'){
                    sb.append(s[i].charAt(j));
                
                }
                else if(temp[i][j]=='.'){
                    sb.append(" ");
                    cnt++;
                }
            }
            copy[i]=sb.toString();
            sb.setLength(0);
        }
    
        return copy;
    }
    static String[] remove(String[] s){
        String[] copy= new String[s.length];
        int row=s.length;
        int col=s[0].length();
        int cnt=0;
        char[][] temp = new char[row][col];

        for(int i=0;i<s[0].length();i++){
            Stack<Character> stack=new Stack<Character>();
            for(int j=0;j<row;j++){
                if(s[j].charAt(i)!=' '){
                   stack.push(s[j].charAt(i));
                }
            }
            for(int j=row-1;j>=0;j--){
                if(stack.isEmpty()){
                    temp[j][i]=' ';
                }
                else{
                    temp[j][i]=stack.pop();
                }
            }
        }
        for(int i=0;i<row;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<col;j++){
                sb.append(temp[i][j]);
            }
            copy[i]=sb.toString();
            sb.setLength(0);
        }
        return copy;

    }
    
}