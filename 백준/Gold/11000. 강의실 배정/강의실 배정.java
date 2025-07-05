
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

        arr = new Node[N];


        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new Node(start, end);
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.start - o2.start;
            }
        });
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(arr[0]);
        for (int i = 1; i < N; i++) {
            Node current = pq.peek();
            if (current.end <= arr[i].start) {
                pq.poll();
                current.end = arr[i].end;
                pq.add(current);
            } else {
                pq.add(arr[i]);
            }

        }
        System.out.println(pq.size());
    }
}