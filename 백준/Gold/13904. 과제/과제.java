import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[T][2];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i][0] = d;
            arr[i][1] = w;
        }
        Arrays.sort(arr, ((x, y) -> y[1] - x[1]));
        boolean[] ck = new boolean[1001];
        int point = 0;
        for (int i = 0; i < arr.length; i++) {
            int d = arr[i][0];
            int w = arr[i][1];
            for (int j = d; j > 0; j--) {
                if (!ck[j]) {
                    point += w;
                    ck[j] = true;
                    break;
                }
            }
        }
        System.out.println(point);
    }
}
