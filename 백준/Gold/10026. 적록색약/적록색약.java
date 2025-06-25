
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char arr[][];
	static int result = 0;
	static int blind_result = 0;
	static int visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new char[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < n; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result += bfs(j, i, false);

			}
		}
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				blind_result += bfs(j, i, true);
			}
		}

		System.out.println(result + " " + blind_result);
	}

	private static int bfs(int x, int y, boolean isBlind) {
		if (visited[y][x] == 1)
			return 0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			if (visited[temp[1]][temp[0]] == 1)
				continue;
			visited[temp[1]][temp[0]] = 1;
			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				if (!isBlind) {
					if (visited[ny][nx] == 0 && arr[temp[1]][temp[0]] == arr[ny][nx]) {
						q.add(new int[] { nx, ny });
					}
				} else {
					if (visited[ny][nx] == 0) {
						if (arr[ny][nx] == 'B') {
							if (arr[temp[1]][temp[0]] == 'B')
								q.add(new int[] { nx, ny });
						} else {
							if (arr[temp[1]][temp[0]] != 'B')
								q.add(new int[] { nx, ny });
						}

					}
				}

			}
		}
		return 1;
	}

}
