import java.io.*;
import java.util.*;

public class Main {


    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < N; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int total = 0;
        while(start <= N && end <= N) {
            if(total >= S && min > end - start)
                min = end - start;
            if(total < S)
                total += arr[end++];
            else
                total -= arr[start++];
        }

        if(min == Integer.MAX_VALUE)
            System.out.println("0");
        else
            System.out.println(min);
    }
}