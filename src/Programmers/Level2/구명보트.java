import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 구명보트를 최대한 적게 사용하려면 하나의 보트에 최대한 많은 사람을 태워야한다.
        // 하나의 보트에 최대한 많은 사람을 태우려면 가능한 무거운 사람과 가능한 가벼운 사람이
        // 짝을 짓도록 해야 한다.
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;
        while (i < j) {
            if (people[i] + people[j] <= limit) { // 두 명씩 타는 경우
                i++; 
            }
            j--;
        }
        return people.length - i;
    }
}
