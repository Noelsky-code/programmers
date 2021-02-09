import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        for(int i=0;i<skill_trees.length;i++){
            int len =skill_trees[i].length();
            boolean tag=true;
            LinkedList<String> list = new LinkedList<String>();
            LinkedList<String> skills=new LinkedList<String>();
            for(int j=0;j<len;j++){
                list.addLast(skill_trees[i].substring(j,j+1));
            }
            for(int j=0;j<skill.length();j++){
                skills.addLast(skill.substring(j,j+1));
            }
            for(int j=0;j<len;j++){
                String temp = list.removeFirst();
                if(skills.contains(temp)){//스킬에 포함되있다면
                    if(!skills.removeFirst().equals(temp)){
                        tag=false;
                        break;
                    }
                }
            }
            if(tag)answer++;
            
        }
        return answer;
    }
}