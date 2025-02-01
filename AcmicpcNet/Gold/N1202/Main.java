package AcmicpcNet.Gold.N1202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    private static boolean collision(int[] r1, int[] r2) {
        int d = r2[0] - r1[0];
        return !(r1[1] + r2[1] < d || d < Math.abs(r1[1] - r2[1]) || d == 0);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] C = new int[N][2];
        for (int i = 0; i < N; i++) {
            C[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        Arrays.sort(C, Comparator.comparingInt(c -> c[0]));

        boolean flag = false;
        for (int i = 1; i < N; i++) {
            if (collision(C[i-1], C[i])) {
                flag = true;
                break;
            }
        }

        if (flag) {
            bw.write("NO");
        } else {
            bw.write("YES");
        }

        bw.flush();
        bw.close();
    }
}
