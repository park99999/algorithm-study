
import java.io.*;
import java.util.*;


public class Main {
    static class Node {
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] map;
    static int N,M;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);

        System.out.println(result);
    }
    static void dfs(int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    q.add(new Node(i,j));
                }
            }
        }
        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        while(!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x; // 현재 값
            int y = now.y; //

            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(0<=nx && nx<N && 0<=ny && ny<M) {
                    if(temp[nx][ny] == 0) {
                        q.add(new Node(nx,ny));
                        temp[nx][ny] = 2;
                    }
                }
            }
        }
        int cnt =0;
        for(int i=0; i<N ; i++) {
            for(int j=0; j<M; j++) {
                if(temp[i][j] == 0) {
                    cnt++;
                }
            }
        }
        result = Math.max(cnt,result);
    }
}