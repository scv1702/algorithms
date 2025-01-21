package AcmicpcNet.Bronze.N2420;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] arr = Arrays.stream(br.readLine().split(" "))
            .mapToLong(Long::parseLong)
            .toArray();
        long res = Math.abs(arr[0] - arr[1]);

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}
