import java.util.*;
import java.io.*;

public class Main {
    static int N, L, R;
    static int[][] arr;

    static boolean[][] visit;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int result =0;

    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            visit = new boolean[N][N];
            boolean isMoved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            int avg = sum / list.size();
                            for (int k = 0; k < list.size(); k++) {
                                int x = list.get(k)[0];
                                int y = list.get(k)[1];
                                arr[x][y] = avg;
                            }
                            isMoved = true;
                        }
                    }
                }
            }
            if (!isMoved)
                break;
            result++;
        }
        System.out.println(result);
    }
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        list = new ArrayList<>();

        q.add(new int[] { x, y });
        list.add(new int[] { x, y });
        visit[x][y] = true;
        int sum = arr[x][y];

        while (!q.isEmpty()) {
            int[] t = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visit[nx][ny]) {
                        int tmp = Math.abs(arr[t[0]][t[1]] - arr[nx][ny]);
                        if (tmp >= L && tmp <= R) {
                            visit[nx][ny] = true;
                            q.add(new int[] { nx, ny });
                            list.add(new int[] { nx, ny });
                            sum += arr[nx][ny];
                        }
                    }
                }
            }
        }
        return sum;
    }
}
