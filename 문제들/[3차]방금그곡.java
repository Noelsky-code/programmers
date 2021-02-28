//kmp 활용했음 . 오랜만에 kmp 써서 헷갈려서 구글링함 . 

import java.util.*;


class Solution {
    
    static int[] pi;
    
    public String solution(String m, String[] musicinfos) {
        m=m.replaceAll("C#","Z");
        m=m.replaceAll("D#","X");
        m=m.replaceAll("F#", "Y");
        m=m.replaceAll("G#", "T");
        m=m.replaceAll("A#", "K");

        pi=new int[m.length()];
        int time=0;
        //String[] musicinfos={"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        get_pi(m);
        String answer="";
        for(String s:musicinfos){
            String[] music =s.split(",");
            music[3]=music[3].replaceAll("C#","Z");
            music[3]=music[3].replaceAll("D#","X");
            music[3]= music[3].replaceAll("F#", "Y");
            music[3]= music[3].replaceAll("G#", "T");
            music[3]=music[3].replaceAll("A#", "K");
            String temp="";
            String[] time_a = music[0].split(":");
            String[] time_b = music[1].split(":");
            int a= Integer.parseInt(time_b[0])-Integer.parseInt(time_a[0]);
            int b= Integer.parseInt(time_b[1])-Integer.parseInt(time_a[1]);
            int time_t=a*60+b;
            int temp_t=time_t;
            int len= music[3].length();
            while(true){
                if(len>=temp_t){
                    temp=temp+music[3].substring(0,temp_t);
                    break;
                }
                else{
                    temp=temp+music[3];
                }
                temp_t-=len;
            }//초기 설정 
            
                

            int j=0;
            boolean check=false;
            for(int i=0;i<temp.length();i++){
                while(j>0&&temp.charAt(i)!=m.charAt(j)){
                    j=pi[j-1];
                }
                if(m.charAt(j)==temp.charAt(i)){
                    if(j==m.length()-1){
                        check=true;
                        break;
                    }
                    else{
                        j++;
                    }
                }
            }
            if(check){
                
                System.out.println(time_t);
                if(time_t>time){
                    time=time_t;
                    answer=music[2];
                }
            }
           
           
        }
        if(answer.equals("")){
            answer="(None)";
        }
        return answer;

    }
    static void get_pi(String m){
        int j=0;
        for(int i=1;i<m.length();i++){
            while(j>0&&m.charAt(i)!=m.charAt(j)){
                j=pi[j-1];
            }
            if(m.charAt(i)==m.charAt(j)){
                pi[i]=++j;
            }
        }
    }

}