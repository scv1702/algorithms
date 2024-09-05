package AcmicpcNet.Bronze.N2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int k = 6;
        for (int num = 1, answer = 1; num <= N + k; k += 6, answer++) {
            if (N <= num) {
                System.out.println(answer);
                break;
            }
            num += k;
        }
    }
}
