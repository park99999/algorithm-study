import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int start = arr[0];
        answer = start;
        while(true){
            int cnt = 0;
            for(int i =1; i< arr.length; i ++){
                if(answer % arr[i] != 0)
                    cnt ++;
            }
            if(cnt ==0)
                return answer;
            else
                answer += start;
        }
        //return answer;
    }
}