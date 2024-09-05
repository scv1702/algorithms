package AcmicpcNet.Bronze.N15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final long r = 31L;
    private static final long M = 1234567891L;

    private static long pow(long i) {
        long result = 1;
        for (int j = 0; j < i; j++) {
            result = (result * r) % M;
        }
        return result % M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int L = Integer.parseInt(br.readLine());
        String S = br.readLine();
        long answer = 0;
        for (int i = 0; i < L; i++) {
            answer += (pow(i) * (S.charAt(i) - 'a' + 1)) % M;
        }
        System.out.println(answer % M);
    }
}