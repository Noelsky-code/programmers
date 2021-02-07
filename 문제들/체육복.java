import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n=5;
        int answer=0;
        int [] lost = {2,4};
        int [] reserve= {3};
        int [] st= new int[n];
        for(int i=0;i<n;i++){
            st[i]=1;
        }
        for(int i:lost){
            st[i-1]--;
        }
        for(int i:reserve){
            st[i-1]++;
        }
        int temp=0;
        for(int i=0;i<n;i++){
            if(st[i]==2){
                if(i==0){
                    if(st[i+1]==0){
                        st[i+1]++;
                        st[i]--;
                    }
                }
                else if(i==n-1){
                    if(st[i-1]==0){
                        st[i-1]++;
                        st[i]--;
                    }
                
                }
                else{
                    if(st[i-1]==0){
                        st[i]--;
                        st[i-1]++;
                    }
                    else if(st[i+1]==0){
                        st[i]--;
                        st[i+1]++;
                    }
                }
            }
        }
    
        for(int i:st){
            if(i>=1){
                answer++;
            }        
        }
        System.out.println(answer);

    }
}
