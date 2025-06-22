import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,start;
	static ArrayList<Node>[] arr;
	static int[] dist;
	static int[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		arr = new ArrayList[V+1];
		dist = new int[V+1];
		for(int i=1; i <= V; i ++) {
			dist[i] = Integer.MAX_VALUE;
		}
		visited = new int[V+1];
		for(int i=1; i < V+1; i ++) {
			arr[i] = new ArrayList<Node>();
		}
		for(int i =0; i < E; i ++) {
			st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				arr[from].add(new Node(to,cost));
			
		}
		dijstra(start);
		for(int i =1; i <= V; i ++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {
				System.out.println(dist[i]);
			}
		}
	}
	private static void dijstra(int current) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start,0));
		dist[start] = 0;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int cur = n.end;
			
			if(visited[cur] == 1)
				continue;
			visited[cur] = 1;
			for(int i =0; i < arr[cur].size(); i ++) {
				Node temp_n = arr[cur].get(i);
				if(dist[temp_n.end] > dist[cur] + temp_n.cost) {
					dist[temp_n.end] = dist[cur] + temp_n.cost;
					pq.add(new Node(temp_n.end,dist[temp_n.end]));
				} 
			}
		}
		
	}
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		public Node( int to, int cost) {
			super(); 
			this.end = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}
	}
}
