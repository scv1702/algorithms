class Solution {
    public String solution(int a, int b) {
        int[] lastDayOfMonth = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] dayOfTheWeek = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        int day = 0;
        for (int m = 0; m < a - 1; m++) {
            day += lastDayOfMonth[m];
        }
        day += b;
        int lastDayOfTheWeek = (4 + day % 7) % 7;
        return dayOfTheWeek[lastDayOfTheWeek];
    }
}
