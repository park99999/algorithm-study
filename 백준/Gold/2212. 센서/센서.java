
import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Queue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<N-1; i++) {
            q.offer(arr[i + 1] - arr[i]);
        }

        int answer = 0;
        for(int i = 0; i<N-K; i++) {
            answer += q.poll();
        }

        System.out.println(answer);
    }
}