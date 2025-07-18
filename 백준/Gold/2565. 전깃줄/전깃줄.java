
import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static class Node implements Comparable<Node> {
        int from, to;

        public Node(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Node n) {
            return this.from - n.from;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(from, to);
        }

        Arrays.sort(nodes);

        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int i=1; i<N; i++) {
            for(int j=0; j<i; j++) {

                if(nodes[j].to < nodes[i].to && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;

                }
            }
        }

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);

    }

}