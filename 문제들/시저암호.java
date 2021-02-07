char[] chars = s.toCharArray();
StringBuilder sb= new StringBuilder();
for(int i=0;i<s.length();i++){
    if(chars[i]==' ')continue;
    char c= chars[i];
    int temp = c+n;
    if('a'<=c&&'z'>=c){
        
        if(temp>(int)('z'))temp-=26;
    }
    else if('A'<=c&&'Z'>=c){
        
        if(temp>(int)('Z'))temp-=26;

    }
    sb.append((char)temp);


}