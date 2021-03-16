class Solution {
    public boolean solution(int[][] key, int[][] lock) {
       int key_length= key.length;
        int lock_length=lock.length;
        int zero=0;
        int[][] lock_temp= new int[lock_length+2*(key_length-1)][lock_length+2*(key_length-1)];
        for(int i=0;i<lock_temp.length;i++){
            for(int j=0;j<lock_temp.length;j++)lock_temp[i][j]=-1;
        }
        for(int i=key_length-1;i<key_length+lock_length-1;i++){
            for(int j=key_length-1;j<key_length+lock_length-1;j++){
                lock_temp[i][j]=lock[i-key_length+1][j-key_length+1];
                if(lock[i-key_length+1][j-key_length+1]==0)zero++;
            }
        }
        if(zero==0){
            return true;
        }
        boolean answer=false;
        for(int i=0;i<4;i++){//4번의 rotate
            for(int row=0;row<lock_temp.length-key_length+1;row++){
                for(int col=0;col<lock_temp.length-key.length+1;col++){
                    if(check(key,lock_temp,row,col,zero)){
                        return true;
                    }
                }
            }
            key=rotate(key);
        }
        return false;
    }
    static boolean check(int[][] key, int[][] lock,int row,int col,int zero){//키와 자물쇠가 맞는지 확인하는 함수 
       boolean flag=false;
       int sum=0;
        for(int i=row;i<row+key.length;i++){
            for(int j=col;j<col+key.length;j++){
                if(lock[i][j]==-1){
                    continue;
                }
                int a=lock[i][j]^key[i-row][j-col];
                if(lock[i][j]==1&&key[i-row][j-col]==1)return false;
                if(0==lock[i][j]&&a==1){
                    sum++;
                }
            }
        }
        if(sum==zero){
            flag=true;
        }
        return flag;
        
    }
    static int[][] rotate(int[][] key){//key를 회전하는 힘수 
        int temp[][]= new int[key.length][key.length];

        for(int i=0;i<key.length;i++){
            for(int j=0;j<key.length;j++){
                temp[i][j]=key[key.length-1-j][i];
            }
        }
        return temp;
    }

}