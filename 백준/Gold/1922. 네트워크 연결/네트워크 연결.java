
import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        int[][] nodes = new int[M][3];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Integer.parseInt(st.nextToken());
            nodes[i][1] = Integer.parseInt(st.nextToken());
            nodes[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nodes, Comparator.comparingInt(o->o[2]));
        int result=0;
        for (int[] node : nodes) {
            if(union(node[0],node[1])) {
                result += node[2]; // 비용 더하
            }
        }
        System.out.println(result);
    }
    static int find(int a){
        if(a == arr[a])
            return a;
        return arr[a] = find(arr[a]);
    }
    static boolean union(int from, int to){
        int a = find(from);
        int b = find(to);
        if(a != b) {
            arr[a] = b;
            return true;
        }
        return false;
    }
}