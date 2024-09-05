package AcmicpcNet.Bronze.N30802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int N = Integer.parseInt(br.readLine());
        int[] sizes = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int[] products = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int T = products[0]; // 티셔츠는 같은 사이즈의 T장 묶음으로만 주문 가능
        int P = products[1]; // 펜은 남거나 부족해서는 안되고, P자루 묶음 또는 개별 주문 가능
        int shirt = 0;
        for (int size : sizes) {
            shirt += size / T;
            if (size % T > 0) {
                shirt += 1;
            }
        }
        System.out.println(shirt);
        System.out.printf("%d %d", N / P, N % P);
    }
}
