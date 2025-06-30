import java.io.*;
import java.util.*;

public class Main {

	static int R,C;
	static int arr[][];
	static int visit_arr[][];
	static int dx [] = {0,0,1,-1};
	static int dy [] = {1,-1,0,0};
	static int visit_alpha[] = new int[26];
	static int result = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[R][C];
        visit_arr = new int[R][C];
        for(int i = 0; i < R; i ++) {
        	st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	for(int j =0; j < C; j ++) {
        		arr[i][j] = s.charAt(j) - 'A';
        	}
        }
        dfs(arr[0][0],0,0,0);
        System.out.println(result);
    }
    private static void dfs(int start,int x, int y,int depth) {
    	//탈출
    	if(visit_alpha[start] == 1) {
    		result = Math.max(result,depth);
    		return;
    	}
    	
    	
    	// 루프
    	
    	for(int i =0; i < 4; i ++) {
    		int new_x = x + dx[i];
    		int new_y = y + dy[i];
    		if(new_x < 0 || new_x >=C || new_y <0 || new_y >= R)
    			continue;
    		visit_alpha[start]  = 1;
    		dfs(arr[new_y][new_x],new_x,new_y,depth+1);
    		visit_alpha[start]  = 0;
    	}
    }
}