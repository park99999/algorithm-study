import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] map;
    static int[] chicken_idx;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Node> homes = new ArrayList<Node>();
    static ArrayList<Node> chickens = new ArrayList<Node>();
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    homes.add(new Node(j, i));
                }
                else if(map[i][j] == 2){
                    chickens.add(new Node(j, i));
                }
            }
        }
        chicken_idx = new int[chickens.size()];
        comb(0, 0 );
        System.out.println(result);
    }

    private static void comb(int cnt, int start) {
        if(cnt == M) {
            int sum = 0;
            for(int i =0; i< homes.size(); i++) {
                int min_dist = Integer.MAX_VALUE;
                Node home = homes.get(i);
                for(int j = 0; j < chickens.size(); j++) {
                    if(chicken_idx[j] ==1) {
                        Node chicken = chickens.get(j);
                        int dist = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
                        min_dist = Math.min(min_dist, dist);
                    }
                }
                sum += min_dist;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            chicken_idx[i] = 1;
            comb(cnt + 1, i + 1);
            chicken_idx[i] = 0;
        }
    }
}