class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
		char[][] map = new char[m][n];
		
		for(int i = 0 ; i < m ; ++i) {
			 map[i]=board[m-i-1].toCharArray();
		}
        while(true){
            int [][] visited = new int[m][n];
            boolean flag = true;
            for(int i =0; i < m-1; i ++){
                for(int j =0; j < n-1; j ++){
                    if(map[i][j] == 'x'){
                        continue;
                    }
                    char temp = map[i][j];
                    if(map[i][j+1]==temp&&map[i+1][j]==temp&&map[i+1][j+1]==temp){
                        visited[i][j]=1;
                        visited[i][j+1]=1;
                        visited[i+1][j]=1;
                        visited[i+1][j+1]=1;
                        flag=false;
                    }
                }
            }
            if(flag){
                break;
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(visited[i][j] == 1){
                        map[i][j]='x';
                        answer++;
                    }
                }
            }
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(map[i][j]=='x'){
                       for(int k=i;k<m;k++){
                           if(map[k][j]=='x'){
                               continue;
                           }
                           map[i][j]=map[k][j];
                           map[k][j]='x';
                           break;
                       }
                    }
                }
            }
        }
        return answer;
    }
}