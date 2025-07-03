
import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        int idx;
        int height;
        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    static int N, K;
    static int[] arr;
    static int answer = 0;
    static Stack<Node> stack = new Stack<Node>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<N;i++) {
            while(!stack.isEmpty()) {
                if(stack.peek().height >= arr[i]) {
                    System.out.print( (stack.peek().idx + 1 )+" ");
                    break;
                }
                stack.pop();
            }

            if(stack.isEmpty()) {
                System.out.print("0 ");
            }

            stack.push(new Node(i, arr[i]));

        }
    }
}