import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] visited;
    static class Star{
        double x;
        double y;
        public Star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
    static class Node{
        int to;
        double cost;
        public Node(int to, double cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static ArrayList<Star> stars;
    static ArrayList<Node>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        visited = new int[N];
        nodes = new ArrayList[N];
        stars = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars.add(new Star(x, y));
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i ==j) continue;
                Star A = stars.get(i);
                Star B = stars.get(j);
                nodes[i].add(new Node(j,calcDistance(A,B)));
                nodes[j].add(new Node(i,calcDistance(A,B)));
            }
        }
        Queue<Node> q = new PriorityQueue<>((o1, o2) -> Double.compare(o1.cost, o2.cost));
        q.offer(new Node(0,0));
        int cnt=0;
        double sum = 0.0;
        while (!q.isEmpty()){
            Node node = q.poll();
            int to = node.to;
            double cost = node.cost;
            if(visited[to]==1) continue;
            visited[to] = 1;
            sum += cost;
            cnt++;
            if(cnt==N) break;

            for(Node n: nodes[to]){
                if(visited[n.to]==0){
                    q.add(n);
                }
            }
        }

        System.out.printf("%.2f", sum);
    }

    private static double calcDistance(Star a, Star b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}