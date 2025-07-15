import java.io.*;
import java.util.*;


public class Main {
    static int N,K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        for(int i=1; i <= N ; i++)
        {
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[K+1];

        for(int i = 1; i <= K; i++){
            dp[i]=Integer.MAX_VALUE-1;
        }
        for(int i = 1; i <= N; i++){
            for(int j = arr[i]; j <= K; j++){
                dp[j]=Math.min(dp[j],dp[j-arr[i]]+1);
            }
        }

        if(dp[K]==Integer.MAX_VALUE-1)
            System.out.println(-1);
        else
            System.out.println(dp[K]);
    }
}