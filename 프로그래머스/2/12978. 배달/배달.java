import java.util.*;

class Solution {
    static class Node{
        int to;
        int from;
        int cost;
        public Node(int to, int from, int cost){
            this.to = to;
            this.from = from;
            this.cost = cost;
        }
    }
    static int[] distance;
    static ArrayList<Node>[] arr;
    static boolean[] visited;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        arr = new ArrayList[N];
        distance = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0; i < road.length; i++){
            int from = road[i][0];
            int to = road[i][1];
            int cost = road[i][2];
            arr[from - 1].add(new Node(to, from, cost));
            arr[to - 1].add(new Node(from, to, cost));
        }

        for(int i = 0; i < N; i++){
            visited = new boolean[N];    
            distance[i] = bfs(i);    
        }

        for (int i = 0; i < N; i++) {
            if (distance[i] <= K) answer++;
        }
        return answer;
    }
    
    private int bfs(int targetIdx){
        final int INF = Integer.MAX_VALUE;
        int n = arr.length;

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];
            if (d > dist[u]) continue; 
            for (Node e : arr[u]) {
                int v = e.to - 1; 
                int nd = d + e.cost;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        return dist[targetIdx];
    }
}