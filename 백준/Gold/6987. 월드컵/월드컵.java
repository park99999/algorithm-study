import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    static int[][] ans;
    static int[][] check;
    static boolean correct;
    static ArrayList<Point> list = new ArrayList<>();
    static LinkedList<Integer> set = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dfs(0, 0);

        for (int i = 0; i < 4; i++) {
            ans = new int[6][3];
            check = new int[6][3];
            correct = false;
            String[] lines = br.readLine().split(" ");
            int count = 0;
            for(int x = 0 ; x < 6 ; x++){
                for(int y = 0 ; y < 3 ; y++){
                    check[x][y] = Integer.parseInt(lines[count++]);
                }
            }
            dfs2(0);
            if(correct){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }
//        System.out.println(list);
    }

    static void dfs(int depth, int count) {
        if (count == 2) {
            list.add(new Point(set.get(0), set.get(1)));
            return;
        }

        for (int i = depth; i < 6; i++) {
            set.push(i);
            dfs(i + 1, count + 1);
            set.poll();
        }
    }
    static void dfs2(int count){
        if(correct) return;
        if(count == 15){
            check();
            return;
        }
        Point p = list.get(count);
        int me = p.x;
        int opponent = p.y;
        for(int i = 0 ; i < 3 ; i++){
            ans[me][i] ++;
            ans[opponent][2 - i] ++;
            dfs2(count + 1);
            ans[me][i] --;
            ans[opponent][2 - i] --;
        }


    }
    static void check(){
        boolean flag = true;
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(ans[i][j] != check[i][j]) flag = false;
            }
//            System.out.println();
        }
        if(flag) correct = true;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y +")";
    }
}