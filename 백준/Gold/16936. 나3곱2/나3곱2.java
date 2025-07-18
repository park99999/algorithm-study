
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> idxMap = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            idxMap.put(arr[i], i);
        }
        
        int[] indegree = new int[N];
        int[] next = new int[N];
        Arrays.fill(next, -1);

        for (int i = 0; i < N; i++) {
            long x = arr[i];
            if (idxMap.containsKey(x * 2)) {
                int j = idxMap.get(x * 2);
                next[i] = j;
                indegree[j]++;
            }
            if (x % 3 == 0 && idxMap.containsKey(x / 3)) {
                int j = idxMap.get(x / 3);
                next[i] = j;
                indegree[j]++;
            }
        }
        
        int start = 0;
        for (int i = 0; i < N; i++) {
            if (indegree[i] == 0) {
                start = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cur = start;
        for (int k = 0; k < N; k++) {
            sb.append(arr[cur]);
            if (k < N - 1) sb.append(' ');
            cur = next[cur];
        }
        System.out.println(sb);
    }
}