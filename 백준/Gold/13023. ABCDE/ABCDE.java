import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main  {
	static int N,M;
	static int result =0;
	static ArrayList<Integer>[] arr;
	static int visit[];
	 public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new int [N];
		arr = new ArrayList[N];
		for(int i=0; i < N; i ++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i =0; i <N; i ++) {
			dfs(i,0);
			if(result == 1) {
				break;
			}
		}
		System.out.println(result);
		
	}
	 private static void dfs(int start,int depth) {
		 if(depth  ==4) {
			 result = 1;
			 for(int i =0; i <N; i ++) {
				 visit[i] =1;
			 }
			 return;
		 }
		 visit[start] = 1;
		 for(int i =0; i < arr[start].size(); i ++) {
			 int temp = arr[start].get(i);
			 if(visit[temp]==0) {
				 visit[temp] = 1;
				 dfs(temp,depth+1);
				 
			 }
		 }
		 visit[start] = 0;
			 
		 
	 }
}
