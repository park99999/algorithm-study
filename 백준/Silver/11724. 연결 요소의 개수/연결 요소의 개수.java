import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        root = new int[N+1];
        for (int i = 1; i <= N; i++) { root[i] = i;}
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }
        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[find(i)] = 1;
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(arr[i] == 1) answer++;
        }
        System.out.println(answer);
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