class Solution {
    static int answer;
    static int visited[];
    public int solution(int n, int[][] computers) {
        answer = 0;
        visited = new int[n];
        for(int i =0; i <n; i ++){
            visited[i] = 1;
            dfs(i,n,computers);
        }
        return n-answer;
    }
    private static void dfs(int start, int n, int[][] computers){
        for(int i = 0; i < n; i ++){
            if(computers[start][i] == 1){
                if(visited[i] == 0){
                    visited[i] = 1;
                    answer ++;
                    dfs(i,n,computers);
                }

            }
        }
    }

}