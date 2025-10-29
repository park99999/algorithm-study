import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        
        Arrays.sort(people);
        int total = 0;
        int left_idx = 0;
        int right_idx = people.length-1;
        int cnt = 0;
        while(left_idx < right_idx){
            int total_weight = people[left_idx] + people[right_idx];
            if(total_weight <= limit){
                left_idx ++;
                right_idx --;
                cnt ++;
            }
            else
                right_idx --;
        }
        return answer - 2*cnt + cnt;
    }
}