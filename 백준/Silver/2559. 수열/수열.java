
import java.io.*;
import java.util.*;

public class Main {


    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int total = 0;
        for (int i = 0; i < K; i++) {
            total += arr[i];
        }
        for(int i = 0 ; i < N-K+1 ; i++) {
            int data = 0;

            for(int j =i ; j < i+K ; j++) {
                data+= arr[j];
            }
            total = Math.max(total, data);
        }
        System.out.println(total);
    }
}