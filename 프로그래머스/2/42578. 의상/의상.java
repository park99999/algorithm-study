import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> key = new ArrayList<String>();
        for(int i = 0; i < clothes.length; i ++){
            //이미 존재하면
            if(map.containsKey(clothes[i][1])){
                int temp = map.get(clothes[i][1]);
                temp = temp +1;
                map.replace(clothes[i][1],temp);
            }
            else{
                map.put(clothes[i][1],2);
                key.add(clothes[i][1]);
            }
        }
        for(int i =0 ; i < map.size(); i ++){
            answer *= map.get(key.get(i));
        }
        return answer-1;
    }
}