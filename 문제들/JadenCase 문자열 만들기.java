class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        s=s.toLowerCase();
        boolean check=true;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' '){
                check=true;
                sb.append(c);
            }
            else if(c>='a'&&c<='z'&&check){
                c=Character.toUpperCase(c);
                check=false;
                sb.append(c);
            }
            else{
                check=false;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}