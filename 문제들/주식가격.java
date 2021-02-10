import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] answer= new int[prices.length];
        Stack<Stock> stack=new Stack<Stock>();

        for(int i=0;i<prices.length;i++){
            if(stack.isEmpty()){//스택이 비었다면
                stack.push(new Stock(i,prices[i]));
            }
            else{//스택이 차있다면 
                while(stack.peek().price>prices[i]&&\){//가격이 하락했다면
                    Stock temp=stack.pop();//가장 위에있는걸 빼내고
                    answer[temp.time]=i-temp.time;//기록하기.
                    if(stack.isEmpty())break; 
                }
                stack.push(new Stock(i,prices[i]));
            }    
        }
        while(!stack.isEmpty()){//남아있는거 다 뺴주기
            Stock temp=stack.pop();
            answer[temp.time]=prices.length-1-temp.time;
        }
        for(int i:answer){
            System.out.println(i);
        }
    }
}

class Stock{
    int time;
    int price;
    public Stock(int time,int price){
        this.time=time;
        this.price=price;
    }
}