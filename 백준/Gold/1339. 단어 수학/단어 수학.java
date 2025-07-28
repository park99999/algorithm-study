
import java.util.*;
import java.io.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    static int N;

    static ArrayList<int[]> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j=ch.length-1; j>=0; j--) {
                int pow = (int)Math.pow(10, ch.length-1-j);
                map.put(ch[j]-'A', map.getOrDefault(ch[j]-'A', 0)+pow);

            }
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Comparator.comparingInt(map::get));

        int total=0;
        int num = 10-map.size();
        for(int key : keyList) {
            total += map.get(key)*num;
            num++;
        }
        System.out.println(total);
    }
}
