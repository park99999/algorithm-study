class Solution {
    private int toMinutes(int hhmm) {
        int h = hhmm / 100;
        int m = hhmm % 100;
        return h * 60 + m;
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int peoples = schedules.length;
        int answer = peoples;

        int[] late = new int[peoples]; 

        for (int d = 0; d < 7; d++) {
            int day = (startday + d) % 7; 
            if (day == 0 || day == 6) continue; 

            for (int p = 0; p < peoples; p++) {
                int log = timelogs[p][d];
                int sched = schedules[p];

                int timeA = toMinutes(log);
                int timeB = toMinutes(sched);

                if (timeA - timeB > 10) late[p] = 1; 
            }
        }

        for (int p = 0; p < peoples; p++) {
            if (late[p] == 1) answer--;
        }
        return answer;
    }
}