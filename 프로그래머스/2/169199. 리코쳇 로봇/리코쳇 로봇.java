import java.util.*;
class Solution {
    
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    static class Node{
        int x;
        int y;
        int depth;
        
        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    
    static int [][] map;
    static boolean [][] visited;
    static int x,y;
    public int solution(String[] board) {
        y = board.length;
        x = board[0].length();
        
        map = new int[y][x];
        visited = new boolean[y][x];
        
        Node robot = null;
        Node goal = null;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                    char c = board[i].charAt(j); // ← j로!
                    if (c == 'D') {
                        map[i][j] = 2; // 장애물
                    } else if (c == 'R') {
                        robot = new Node(j, i, 0);
                    } else if (c == 'G') {
                        goal = new Node(j, i, 0);
                    }
                }
            }
        int answer = bfs(robot, goal);
        return answer;
    }
    
    private int bfs(Node robot, Node goal) {
        Queue<Node> q = new LinkedList<>();
        q.add(robot);
        visited[robot.y][robot.x] = true;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if(node.x == goal.x && node.y == goal.y)
                return node.depth;
            
            for(int i =0; i < 4; i ++){
                int nx = node.x;
                int ny = node.y;
                
                
                while (inRange(nx, ny) && map[ny][nx] != 2) {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if (visited[ny][nx] || (node.x == nx && node.y == ny)) continue;

                visited[ny][nx] = true;
                q.add(new Node(nx, ny, node.depth + 1));
            }
        }
        return -1;
    }
    private boolean inRange(int dx, int dy) {
        return dx >= 0 && dy >= 0 && dx < x && dy < y;
    }
}