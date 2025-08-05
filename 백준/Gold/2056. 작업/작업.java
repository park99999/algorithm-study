import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int arr[], task[], dp[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        task = new int[N+1];
        dp = new int[N+1];
        list = new ArrayList[N+1];

        for(int i=1;i<N+1;i++) {
            list[i] = new ArrayList<>();
            String[] split = br.readLine().split(" ");
            arr[i] = Integer.parseInt(split[0]);
            task[i] = Integer.parseInt(split[1]);

            for(int j = 0; j< task[i]; j++) {
                list[Integer.parseInt(split[2+j])].add(i);
            }
        }

        bfs();

        int result = 0; 
        for(int i=1;i<N+1;i++) {
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }

    private static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<N+1;i++) {
            if(task[i] == 0) {
                queue.offer(i);
                dp[i] = arr[i];
            }
        }

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int i=0;i<list[now].size();i++) {
                int next = list[now].get(i);
                dp[next] = Math.max(dp[now]+ arr[next], dp[next]);
                task[next]--;

                if(task[next] == 0) {
                    queue.offer(next);
                }
            }
        }
    }

}