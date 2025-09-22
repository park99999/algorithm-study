import java.util.*;
class Solution {
    static class Dict{
        int index;
        String head;
        int number;
        String tail;
        Dict(int index, String head, String number, String tail){
            this.index = index;
            this.head = head;
            this.number = Integer.parseInt(number);
            this.tail = tail;
        }
    }
    public ArrayList<String> solution(String[] files) {
        ArrayList<String> answer = new ArrayList<>();
        PriorityQueue<Dict> pq = new PriorityQueue<>((a, b) -> {
            int result1 = a.head.compareTo(b.head);
            if (result1 != 0) return result1;

            int result2 = a.number - b.number;
            if (result2 != 0) return result2;
            
            return Integer.compare(a.index, b.index);
        });
        int size = files.length;
        int idx = 1;
        for(String file : files){
            String newFile = file.toUpperCase();
            String headTemp = "";
            String numberTemp = "";
            String tailTemp = "";
            for(int i =0; i < newFile.length(); i ++){
                if(newFile.charAt(i) <= '9' && newFile.charAt(i) >= '0'){
                    int flag = 0;
                    for(int j = i; j < newFile.length(); j ++){
                        if(newFile.charAt(j) <= '9' && newFile.charAt(j) >= '0' && flag ==0){
                             numberTemp += newFile.charAt(j);
                             i++;
                        }
                        else{
                            flag = 1;
                            tailTemp += newFile.charAt(j);
                            i++;
                        }
                    }
                }
                else{
                    headTemp += newFile.charAt(i);
                }
            }
            Dict dict = new Dict(idx,headTemp,numberTemp,tailTemp);
            pq.offer(dict);
            idx ++;
        }
        
        while(!pq.isEmpty()){
            Dict dict = pq.poll();
            int index = dict.index;
            answer.add(files[index-1]);
        }
        return answer;
    }
}