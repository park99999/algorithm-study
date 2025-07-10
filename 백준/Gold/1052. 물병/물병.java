import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (Integer.bitCount(N) > K) {
            answer += 1;
            N += 1;
        }
        System.out.println(answer);
    }
}