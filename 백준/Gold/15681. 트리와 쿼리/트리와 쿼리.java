
import java.util.*;
import java.io.*;

public class Main {
    static int N,R,Q;
    static ArrayList<Integer>[] list, tree;	
    static int parent[];
    static int size[];	
    public static void main(String[] args) throws IOException { 		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());				
        N = Integer.parseInt(st.nextToken());		
        R = Integer.parseInt(st.nextToken());		
        Q = Integer.parseInt(st.nextToken());				
        parent = new int [N+1];		
        size = new int[N+1];		
        list = new ArrayList[N+1];		
        tree = new ArrayList[N+1];				
        for(int i=0; i<list.length; i++) {			
            list[i] = new ArrayList<>();			
            tree[i] = new ArrayList<>();		
        }				
        for(int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }
        makeTree(R, -1);
        countSubtreeNodes(R);
        StringBuffer sb = new StringBuffer();
        while(Q-- > 0) {
            int query = Integer.parseInt(br.readLine());
            sb.append(size[query]).append("\n");
        }		System.out.println(sb);	
    }		
    public static void makeTree(int curNode, int p) {
        for(int node : list[curNode]) {
            if(node != p) {
                tree[curNode].add(node);
                parent[node] = curNode;
                makeTree(node, curNode);
            }
        }
    }
    public static void countSubtreeNodes(int curNode) {
        size[curNode] = 1;
        for(int node : tree[curNode]) {
            countSubtreeNodes(node);
            size[curNode] += size[node];
        }
    }
}
