
import java.io.*;
import java.util.*;


public class Main {
    static class Node implements Comparable<Node> {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.end - o.end;
        }
    }
    static int N, K;
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<Long>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(Long.parseLong(st.nextToken()));
        }

        long result = 0;
        while (pq.size() > 1) {
            long temp1 = pq.poll();
            long temp2 = pq.poll();
            result += temp1 + temp2;
            pq.add(temp1 + temp2);
        }

        System.out.println(result);
    }
}