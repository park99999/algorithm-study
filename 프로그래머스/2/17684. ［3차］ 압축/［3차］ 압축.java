import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> dict = new HashMap<>();
        for(int i =0; i < 26; i ++){
            String temp = "";
            temp += (char)('A' + i);
            dict.put(temp, i +1);
        }
        int idx = dict.size()+1;
        for(int i =0; i < msg.length(); i ++){
            
            String word = "";
            while (i < msg.length() && dict.containsKey(word + msg.charAt(i))) {
                word += msg.charAt(i);
                i++;
            }
            answer.add(dict.get(word));
            if (i < msg.length()) {
                dict.put(word + msg.charAt(i), idx);
                idx++; 
                i--;
            }
        }
        return answer;
    }
}