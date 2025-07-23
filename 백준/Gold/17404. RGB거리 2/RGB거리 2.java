import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] weights = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 3; j++) {
                weights[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int[][][] memo = new int[3][n][3];
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                memo[k][0][j] = weights[0][j];
            }
        }
        for (int k = 0; k < 3; k++) {
            for (int j = 0; j < 3; j++) {
                memo[k][1][j] = weights[1][j] + memo[k][0][k];
            }
        }
        if (n == 2) {
            int answer = Integer.MAX_VALUE;
            answer = Math.min(answer, Math.min(memo[0][1][1], memo[0][1][2]));
            answer = Math.min(answer, Math.min(memo[1][1][0], memo[0][1][2]));
            answer = Math.min(answer, Math.min(memo[2][1][0], memo[0][1][1]));
            System.out.println(answer);
            return;
        }
        for (int k = 0; k < 3; k++) {
            memo[k][2][k] = weights[2][k] + Math.min(memo[k][1][(k+1)%3], memo[k][1][(k+2)%3]);
            memo[k][2][(k+1)%3] = weights[2][(k+1)%3] + memo[k][1][(k+2)%3];
            memo[k][2][(k+2)%3] = weights[2][(k+2)%3] + memo[k][1][(k+1)%3];
        }
        
        int answer = Integer.MAX_VALUE;
        for (int k = 0; k < 3; k++) {
            for (int i = 3; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    memo[k][i][j] = weights[i][j] + Math.min(memo[k][i-1][(j+1)%3], memo[k][i-1][(j+2)%3]);
                }
            }
            answer = Math.min(answer, memo[k][n-1][(k+1)%3]);
            answer = Math.min(answer, memo[k][n-1][(k+2)%3]);
        }
        
        System.out.println(answer);
    }
}
