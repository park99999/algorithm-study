import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{
    static class Node implements Comparable<Node>{
       int to;
       int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int start,end;
    static int result = 0;
    static int visited[];
    static int costDp[];
    static ArrayList<Node>[] list;
    static Queue<Node> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        visited = new int[N+1];
        costDp = new int[N+1];
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            String [] s = br.readLine().split(" ");
            int startPoint = Integer.parseInt(s[0]);
            int endPoint = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            list[startPoint].add(new Node(endPoint,cost));
        }
        String [] s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
        bfs(start);

        System.out.println(costDp[end]);
    }
    public static void bfs(int start_city) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start_city,0));
        Arrays.fill(costDp, Integer.MAX_VALUE);
        costDp[start_city] = 0;

        while(!pq.isEmpty()) {
            Node poll = pq.poll();
             if (poll.cost > costDp[poll.to]) continue;
            visited[poll.to] = 1;

            for(Node a: list[poll.to]) {
                if(visited[a.to] == 1) {
                    continue;
                }
                if(costDp[a.to] > costDp[poll.to]+a.cost) {
                    costDp[a.to] = costDp[poll.to]+a.cost;
                    pq.add(new Node(a.to,costDp[a.to]));
                }

            }
        }

    }
}
