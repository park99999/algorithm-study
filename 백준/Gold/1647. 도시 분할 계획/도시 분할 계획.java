import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Prim
public class Main {
    static int N,M;
    static class Node{
        int to;
        int cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static int[] visited;
    static ArrayList<Node>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        nodes = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b,c));
            nodes[b].add(new Node(a,c));
        }
        Queue<Node> q = new PriorityQueue<>( (o1, o2) -> o1.cost - o2.cost);
        q.add(new Node(1,0));
        int cnt=0;
        int connect=0;
        int maxLine =0;
        while(!q.isEmpty()) {
            Node now = q.poll();
            int to = now.to;
            int cost = now.cost;

            if(visited[to] == 1) continue;

            visited[to] = 1;
            cnt += cost;
            maxLine = Math.max(maxLine, cost);
            connect++;

            if(connect == N) break;

            for(Node nxt : nodes[to]) {
                if(visited[nxt.to]== 0) {
                    q.add(nxt);
                }
            }
        }
        System.out.println(cnt-maxLine);
    }
}