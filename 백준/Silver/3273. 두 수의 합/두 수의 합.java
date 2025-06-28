
import java.io.*;
import java.util.*;

public class Main {


    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int cnt =0;
        while(start < end) {
            int sum = arr[start]+arr[end];
            if (sum == X) {
                cnt++;
                start++;
                end--;
            } else if (sum < X) {
                start++;
            } else
                end--;
        }
        System.out.println(cnt);
    }
}