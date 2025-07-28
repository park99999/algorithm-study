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

        ArrayList<Node> nodes = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.add(new Node(x, y));
        }
        nodes.sort(Comparator.comparingInt(x -> x.x));

        Node before = nodes.get(0);
        int sum = before.y - before.x;
        for(int i=1; i<nodes.size(); i++){
            Node now = nodes.get(i);
            if(now.x <= before.y && now.y <= before.y)
                continue;
            if(now.x <= before.y){
                sum += now.y - before.y;
            }else{
                sum += now.y - now.x;
            }
            before = now;

        }

        System.out.println(sum);
    }
}
