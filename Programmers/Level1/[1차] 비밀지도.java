class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            int decrypted = arr1[i] | arr2[i];
            StringBuilder sb = new StringBuilder();
            int mask = (int) Math.pow(2, n-1);
            while (mask > 0) {
                if ((decrypted & mask) > 0) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
                mask >>>= 1;
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
