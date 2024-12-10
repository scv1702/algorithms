package AcmicpcNet.Silver.N18110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int m = Math.round(n * 0.15f);

        int s = 0;
        for (int i = m; i < n - m; i++) {
            s += arr[i];
        }

        int ans = Math.round(s / (float) (n - 2*m));

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
