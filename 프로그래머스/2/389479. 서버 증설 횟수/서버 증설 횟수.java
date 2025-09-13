class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] servers = new int[24];
        for(int i =0; i < 24; i ++){
            int needServer = 0;
            if(players[i] >= m){
                needServer += ((players[i] - m) / m) + 1;
            }
            int serverCount = 0;
            for(int j = Math.max(0, i - k + 1); j < i; j++){
                serverCount += servers[j];
            }
            
            int add = Math.max(0, needServer - serverCount);
            servers[i] = add;
            answer += add;
            
        }
        
        return answer;
    }
}