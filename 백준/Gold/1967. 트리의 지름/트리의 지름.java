import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        int index;
        int distance;
        Node(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
    static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    static boolean[] visited;
    static int answer =0;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        for(int i=0;i<=N;i++) {
            nodes.add(new ArrayList<Node>());
        }
        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            nodes.get(start).add(new Node(dest, dist));
            nodes.get(dest).add(new Node(start, dist));
        }

        for(int i=1;i<=N;i++) {
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i,0);
        }
        System.out.println(answer);
    }

    static void dfs(int start, int weight) {

        for(int i=0;i<nodes.get(start).size();i++) {
            if(!visited[nodes.get(start).get(i).index]) {
                visited[nodes.get(start).get(i).index] = true;
                dfs(nodes.get(start).get(i).index, nodes.get(start).get(i).distance + weight);
            }
        }
        if(answer < weight) answer = weight;
    }
}