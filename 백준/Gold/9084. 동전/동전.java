

import java.io.*;
import java.util.*;


public class Main {


    static int T, N, M;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<N;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            dp = new int[M+1];

            dp[0] = 1;
            for(int i=0;i<N;i++) {
                for(int j=arr[i]; j<M+1;j++) {
                    dp[j] = dp[j] + dp[j - arr[i]];
                }
            }
            System.out.println(dp[M]);
        }
    }
}