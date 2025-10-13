import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int C,N;
    static int[] cost;
    static int[] people;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cost = new int[N + 1];
        people = new int[N + 1];
        dp = new int[100 * 1000 + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = cost[i]; j < dp.length; j++) {
                dp[j] = Integer.max(dp[j], dp[j - cost[i]] + people[i]);
            }
        }
        int answer = 0;

        for (int i = 1; i < dp.length; i++) {
            if (dp[i] >= C) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }




}