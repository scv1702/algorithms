package AcmicpcNet.Bronze.N10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] splited = br.readLine().split(" ");
            int H = Integer.parseInt(splited[0]);
            int N = Integer.parseInt(splited[2]);
            int X = (N % H == 0) ? N / H : N / H + 1;
            int Y = (N % H == 0) ? H : N % H;
            System.out.printf("%d%02d\n", Y, X);
        }
    }
}
