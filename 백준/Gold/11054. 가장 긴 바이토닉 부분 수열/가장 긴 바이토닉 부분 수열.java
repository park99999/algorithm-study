import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] dp= new int[n][3];  //내림

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i][0] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if(dp[i][0]>dp[j][0]) dp[i][1] = Math.max(dp[i][1], dp[j][1]+1);
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = n-1; j >i ; j--) {
                if(dp[i][0]>dp[j][0]) dp[i][2] = Math.max(dp[i][2], dp[j][2]+1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i][1]+dp[i][2]);
        }
        System.out.println(++ans);
    }
}