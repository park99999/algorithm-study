
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for(int i = 1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 1; j<=N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 2, 0);

        System.out.println(count);
    }
    
    static void dfs(int row, int col, int dir){
        if(row>N || col>N || map[row][col] == 1)
            return;
        if(dir == 2){
            if(map[row][col-1] == 1 || map[row-1][col] == 1)
                return;
        }
        if(row == N && col == N){
            count++;
            return;
        }

        if(dir == 0){
            dfs(row, col+1, 0);
            dfs(row+1, col+1, 2);
        }
        else if(dir == 1){
            dfs(row+1, col, 1);
            dfs(row+1, col+1, 2);
        }
        else{
            dfs(row+1, col+1, 2);
            dfs(row, col+1, 0);
            dfs(row+1, col, 1);
        }
    }
}