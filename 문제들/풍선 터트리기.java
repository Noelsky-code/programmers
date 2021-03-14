import java.util.*;

public class Main {
    //세그먼트 트리 이용하자 .nlogn 으로 가능할듯 . 
    //문제 다풀고 풀이 봄
    //다른사람들은 left나 right의 최솟값중 둘중하나보다 작으면 무조건 성립함을 이용 ..
    // left 0~ length-2 까지 올리면서 .. 왼쪽의 최소값보다 작은걸 set에 넣고 오른쪽에선 반대로 하고 .. 
    //그래서 set size가 답 .. 
    //대단한데?? ㅠㅠ 난 세그먼트트리밖에 생각이안들었는데 .. nlogn에 집착한거같음
    //그래도 2점은 쫌 그렇다?? 
    static int[] tree;
    public static void main(String[] args) {
        int[] a= {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        tree= new int[a.length*4];
        init(0,a.length-1,1,a);
        int answer=0;
        if(a.length==1){
            answer=1;
        }
        else {
            answer=2;
        }
    
        for(int i=1;i<a.length-1;i++){
            int left= find(0,a.length-1,0,i-1,1,a);
            int right=find(0,a.length-1,i+1,a.length-1,1,a);
            if(left<a[i]&&right<a[i]){
                continue;
            }
            System.out.println(a[i]);
            answer++;
        }
        System.out.println(answer);
    }
    static int init(int start,int end, int node,int arr[]){
        if(start==end){
            return tree[node]=arr[start];
        }
        int mid=(start+end)/2;
        
        return tree[node]=Math.min(init(start,mid,node*2,arr),init(mid+1,end,node*2+1,arr));
    }
    
    static int find(int start,int end,int left,int right,int node,int arr[]){
        if(left>end||right<start){
            return 1000000001;
        }
        if(start>=left&&right>=end){
            return tree[node];
        }
        int mid= (start+end)/2;
        return Math.min(find(start,mid,left,right,node*2,arr),find(mid+1,end,left,right,node*2+1,arr));
    }

}