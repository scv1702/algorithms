import java.util.*;

class Solution {

    int from(String t) {
        String[] splited = t.split(":");
        int h = Integer.parseInt(splited[0]);
        int m = Integer.parseInt(splited[1]);
        int s = Integer.parseInt(splited[2]);
        return h * 60 * 60 + m * 60 + s;
    }

    String from(int t) {
        int h = t / (60 * 60);
        int m = (t - h * 60 * 60) / 60;
        int s = t - (h * 60 * 60) - (m * 60);
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public String solution(String playTime, String advTime, String[] logs) {
        int MAX_TIME = from(playTime);
        long[] times = new long[MAX_TIME + 1];
        for (int i = 0; i < logs.length; i++) {
            final String[] splited = logs[i].split("-");
            final int start = from(splited[0]);
            final int end = from(splited[1]);
            times[start] += 1;
            times[end] -= 1;
        }
        // 시간별 시청자 수 계산
        for (int i = 1; i <= MAX_TIME; i++) {
            times[i] += times[i-1];
        }
        // 시간별 누적 재생시간 계산
        for (int i = 1; i <= MAX_TIME; i++) {
            times[i] += times[i-1];
        }

        int at = from(advTime);
        long max = times[at];
        int answer = 0;

        for (int i = at + 1; i <= MAX_TIME; i++) {
            long sum = times[i] - times[i-at];
            if (sum > max) {
                max = sum;
                answer = i - at + 1;
            }
        }

        return from(answer);
    }
}