
import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] map;
    static int 빙하영역;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int simul =0;
        while(true){
            int 빙하수 = 빙하수구하기();
            if(빙하수 ==0){
                System.out.println(0);
                return;
            }
            빙하영역 = 0;
            빙하수영역구하기();
            if(빙하영역 >1)
                break;
            빙하영역시뮬돌리기();
            simul++;
        }
        System.out.println(simul);
    }

    private static void 빙하영역시뮬돌리기() {
        int[][] temp_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, temp_map[i], 0, M);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(temp_map[i][j] != 0){
                    int 주변에바다몇개있니 = 0;
                    for(int k =0 ; k < 4; k ++){
                        int nx = j + dx[k];
                        int ny = i + dy[k];
                        if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                            continue;
                        }
                        if(temp_map[ny][nx] == 0){
                            주변에바다몇개있니 ++;
                        }
                    }
                    if(주변에바다몇개있니 != 0){
                        map[i][j] -= 주변에바다몇개있니;
                        if(map[i][j] < 0){
                            map[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    private static void 빙하수영역구하기() {
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    빙하영역++;
                    Queue<int[]> q = new LinkedList<>();
                    visited[i][j] = true;
                    q.add(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int y = cur[0];
                        int x = cur[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx >= 0 && nx < M && ny >= 0 && ny < N
                                    && !visited[ny][nx] && map[ny][nx] != 0) {
                                visited[ny][nx] = true;
                                q.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
            }
        }
    }

    private static int 빙하수구하기() {
        int cnt =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}