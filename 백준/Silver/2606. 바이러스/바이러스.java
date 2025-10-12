import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] graph;
    static int [] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i =0; i < N+1; i ++){
            graph[i] = new ArrayList<>();
        }

        // union find
        root = new int[N + 1];
        for (int i = 1; i <= N; i++) root[i] = i;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int answer = 0;
        for(int i =2; i <= N; i ++){
            if(find(i)==1)
                answer++;
        }
        System.out.println(answer);
    }
    private static int find(int u){
        if(root[u] == u){
            return u;
        }
        else return root[u] = find(root[u]);
    }

    private static void union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v){
            return;
        }
        if(u > v){
            root[u] = v;
        }
        else{
            root[v] = u;
        }
    }
}