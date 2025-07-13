
import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        result = 0;
        행선택(0);
        System.out.println(result);
    }

    private static void 행선택(int cnt) {
        if(cnt == N) {
            result++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[cnt] = i;
            // 대각선 체크
            if (대각선체크(cnt)) {
                행선택(cnt + 1);
            }
        }
    }

    public static boolean 대각선체크(int col) {
        for (int i = 0; i < col; i++) {
            if (arr[col] == arr[i]) {
                return false;
            }
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        return true;
    }
}