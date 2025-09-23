import java.util.*;
class Solution {
    static HashMap<Integer, Character> map = new HashMap<>();
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        for(int i =0; i < 16; i ++){
            if(i < 10){
                char c = '0';
                map.put(i, (char)(c+i));
            }
            else{
                char c = 'A';
                map.put(i, (char)(c+i%10));
            }
        }
        int num = 0;
        int count = 1;
        int soonseo = p %m;
        while(true){
            if(answer.length() == t)
                break;
            String temp = solve(num,n);
            for(int i = temp.length()-1; i >= 0; i --){
                if(count%m == soonseo){
                    answer += temp.charAt(i);
                    count ++;
                    if(answer.length() == t)
                        break;
                }
                else{
                    count ++;
                }
            }
            num ++;
        }
        
        
        return answer;
    }
    String solve(int num, int n){
        String temp = "";
        int size = num/n;
        while(true){
            temp += map.get(num%n);
            num /= n;
            if(num==0)
                break;
        }
        return temp;
    }
}