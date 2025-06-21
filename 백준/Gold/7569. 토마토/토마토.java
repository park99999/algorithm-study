import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x;
    int y;
    int z;

    public Node(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int dx[] = {-1, 0, 1, 0, 0, 0};
    static int dy[] = {0, 1, 0, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int m, n, h;
    static int arr[][][];
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h + 1][n + 1][m + 1];

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 1; k <= m; k++){
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) queue.add(new Node(k, j, i));
                }
            }
        }
        int result = bfs();
        System.out.println(result);
    }
    private static int bfs() {
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int x = cur.x;
            int y = cur.y;
            int z = cur.z;
            for(int i = 0; i < 6; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if(checkPoint(nz, ny, nx)){
                    queue.add(new Node(nx, ny, nz));
                    arr[nz][ny][nx] = arr[z][y][x] + 1;
                }
            }
        }
        int result = Integer.MIN_VALUE;

        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= m; k++){
                    if(arr[i][j][k] == 0) return -1;
                    result = Math.max(result, arr[i][j][k]);
                }
            }
        }
        if(result == 1) return 0;
        else return (result - 1);
    }
    private static boolean checkPoint(int z, int y, int x){
        if(z < 1 || z > h || y < 1 || y > n || x < 1 || x > m) return false;
        if(arr[z][y][x] == 0) return true;
        else return false;
    }
}
