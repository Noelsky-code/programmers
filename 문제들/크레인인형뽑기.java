//프로그래머스 , 크레인 인형뽑기게임 

import java.util.*;
import java.io.*;

public class Main {
    
    

    public static void main(String[] args) throws IOException {
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int[][] board={{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves= {1,5,3,5,1,2,1,4};
              //board는 5*5~30*30(900) , 숫자는 인형의 종류 
        //터트려진 인형의 개수 return 
        
        int answer = 0;

        int size=0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i:moves){
            size++;//move의 크기 
        }
        int len=0;
        for(int i:board[0]){
            len++;//board의 크기 
        }
        int doll[] = new int[len];//놓여있는 doll의 갯수 
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(board[i][j]!=0)doll[j]++;
            }
        }
        int temp[][]=new int[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                temp[i][j]=board[len-i-1][j];
            }
        }
    
      
        System.out.println();
        for(int i:moves){
            
            if(doll[i-1]>0){//인형의 갯수가 1개 이상이라면 
                int a = temp[doll[i-1]-1][i-1];//꺼낸 인형  
                doll[i-1]--;//갯수 down
               
                if(!stack.isEmpty()){//스택에 존재한다면 
                
                    if(stack.peek().equals(a)){
                        int c= stack.pop();//꺼내고 
                        answer++;//터진거 추가
                       
                    }
                    else{
                        stack.push(a);
                    }
                }
                else{
                    stack.push(a);
                }
            }
        }
       System.out.println(2*answer);
        
    
     }
 }
