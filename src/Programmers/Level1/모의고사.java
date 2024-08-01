import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] points = { 0, 0, 0 };
        int[] p1 = { 1, 2, 3, 4, 5 };
        int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        
        for (int i = 0; i < answers.length; i++) {
            if (p1[i % 5] == answers[i]) {
                points[0]++;
            }
            if (p2[i % 8] == answers[i]) {
                points[1]++;
            }
            if (p3[i % 10] == answers[i]) {
                points[2]++;
            }
        }
        
        int maxPoint = Arrays.stream(points).max().getAsInt();
        
        for (int i = 0; i < 3; i++) {
            if (points[i] == maxPoint) {
                res.add(i+1);
            }
        }
        
        return res;
    }
}
