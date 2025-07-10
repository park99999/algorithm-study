import java.io.*;
import java.util.*;


public class Main {
    static int N, L, R, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int answer = 0;
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt;
        int max;
        int min;
        int sum;
        for(int i=1;i<(1<<N);i++) {
            cnt=0;
            min=Integer.MAX_VALUE;
            max=Integer.MIN_VALUE;
            sum=0;

            for(int j=0;j<N;j++) {
                if((i&(1<<j))>0) {
                    cnt++;
                    min = Math.min(min, arr[j]);
                    max = Math.max(max, arr[j]);
                    sum += arr[j];
                }
            }

            if(cnt<2 || sum<L || sum>R || max-min<X)
                continue;

            answer++;
        }
        System.out.println(answer);
    }
}