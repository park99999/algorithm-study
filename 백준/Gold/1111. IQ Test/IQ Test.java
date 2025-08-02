import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int result = Integer.MIN_VALUE;
    static int cnt_num = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }

        if(list.size() == 1){
            System.out.println('A');
            return;
        }
        int start = list.get(0);
        int next = list.get(1);

        for(int i = -200; i <= 200; i ++){
            for(int j = -20000; j <= 20000; j ++){
                if(start*i + j == next){
                    checkThisOut(i,j);
                }
            }
        }
        if(cnt_num == 1){
            System.out.println(result);
        }
        else if(cnt_num == 0){
            System.out.println('B');
        }
        else{
            System.out.println('A');
        }

    }

    private static void checkThisOut(int a, int b) {
        int cnt =0;
        for(int i =0; i < list.size()-1; i++){
            if(list.get(i)*a + b == list.get(i+1)){
                cnt++;
            }
        }
        int temp = list.get(list.size()-1)*a+b;
        if(cnt == list.size()-1){
            if(temp != result){
                cnt_num++;
                result = temp;
            }
        }
    }
}