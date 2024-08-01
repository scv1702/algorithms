import java.util.*;

/*
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        boolean[] reserveArr = new boolean[n];
        boolean[] lostArr = new boolean[n];
        
        Arrays.sort(lost);
        
        for (int r: reserve) {
            reserveArr[r-1] = true;
        }
        
        for (int l: lost) {
            lostArr[l-1] = true;
        }
        
        for (int l: lost) {
            if (reserveArr[l-1]) { // 여벌 체육복을 가져온 학생이 도난당한 경우
                reserveArr[l-1] = false;
                answer++;
            } else if (l-2 >= 0 && reserveArr[l-2] && !lostArr[l-2]) {
                reserveArr[l-2] = false;
                answer++;
            } else if (l < n && reserveArr[l] && !lostArr[l]) {
                reserveArr[l] = false;
                answer++;
            }
        }
        
        return answer;
    }
}
*/

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int[] uniform = new int[n];
        
        Arrays.fill(uniform, 1);
        
        for (int r: reserve) {
            uniform[r-1]++;
        }
        
        for (int l: lost) {
            uniform[l-1]--;
        }
                
        for (int i = 0; i < n; i++) {
            if (uniform[i] < 1) {
                if (i-1 >= 0 && uniform[i-1] > 1) {
                    uniform[i-1]--;
                } else if (i+1 < n && uniform[i+1] > 1) {
                    uniform[i+1]--;
                } else {
                    answer--;
                }
            }
        }
    
        return answer;
    }
}
