class Solution {
    public int solution(String dirs) {
        int[] OPP = {2, 3, 0, 1};
        int answer = 0;
        int [][][] arr = new int[11][11][4];
        int x = 5;
        int y = 5;
        for(int i =0; i < dirs.length(); i ++){
            int dir = 0;
            int nx = x;
            int ny = y;
            char c = dirs.charAt(i);
            if (c == 'L') { dir = 0; nx = x - 1; }
            else if (c == 'U') { dir = 1; ny = y - 1; }
            else if (c == 'R') { dir = 2; nx = x + 1; }
            else if (c == 'D') { dir = 3; ny = y + 1; }

            if (nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            
            int opp = OPP[dir];
            if (arr[y][x][dir] == 0 && arr[ny][nx][opp] == 0) {
                answer++;
            }

            arr[y][x][dir] = 1;
            arr[ny][nx][opp] = 1;

            x = nx; y = ny;
        }
        return answer;
    }
}