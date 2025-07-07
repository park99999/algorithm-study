import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        K = Integer.parseInt(st.nextToken());
        dp = new int[K+1];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }
        
        System.out.println(dp[K]);
    }
}