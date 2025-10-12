// 크루스칼
import java.io.*;
import java.util.*;

public class Main {
    static int V,E;
    static int[] root;
    static class Node{
        int start;
        int end;
        int cost;

        Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        root = new int[V+1];
        for (int i = 1; i <= V; i++) { root[i] = i;}
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a, b, c));
        }
        int size = pq.size();
        int total = 0;
        for(int i=0; i<size; i++) {
            Node node = pq.poll();
            int start = find(node.start);
            int end = find(node.end);

            if(find(start)!=find(end)) {
                total += node.cost;
                union(node.end, node.start);
            }
        }
        System.out.println(total);
    }
    private static int find(int x){
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(a > b) root[a] = b;
        else root[b] = a;
    }
}