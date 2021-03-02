
import java.util.*;

public class Main {
    
    
    public static void main(String[] args){
        String[] files= {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG","  i12.123123"};
        HashMap<String,Integer>map =new HashMap<String,Integer>();//입력 순서를 저장하기 위한 맵
        int cnt=0;
        for(String s:files){
            map.put(s,cnt++);
        }
        Arrays.sort(files,new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                String t_o1=o1.toLowerCase();
                String t_o2=o2.toLowerCase();
                StringBuilder sb= new StringBuilder();
                String h_o1=get_h(t_o1);
                String h_o2=get_h(t_o2);

                if(h_o1.compareTo(h_o2)==0){//헤드가 같을 경우 
                    int n_o1=Integer.parseInt(get_n(t_o1,h_o1));
                    int n_o2=Integer.parseInt(get_n(t_o2,h_o2));
                    if(n_o1==n_o2){
                        return Integer.compare(map.get(o1),map.get(o2));
                    }
                    return Integer.compare(n_o1,n_o2);
                }
                return h_o1.compareTo(h_o2);
            }
            
        });
        String s="   abc.....1231";
        System.out.println(get_h(s)+":"+get_n(s,get_h(s)));
       
    }
    static String get_h(String s){//head를 얻는 함수 
        int cnt=0;
        while(!(s.charAt(cnt)-'0'>=0&&s.charAt(cnt)-'0'<=9)){
            cnt++;
        }
        return s.substring(0,cnt);
    }
    static String get_n(String s,String head){//number을 얻는 함수
        int len= head.length();
        int cnt=len;
        while(s.charAt(cnt)-'0'>=0&&s.charAt(cnt)-'0'<=9){
            cnt++;
            if(cnt==s.length()){
                break;
            }
            if(cnt-len>=5){
                break;
            }
        }
        return s.substring(len, cnt);
    }

}