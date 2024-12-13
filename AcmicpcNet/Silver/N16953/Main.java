package AcmicpcNet.Silver.N16953;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long[] line = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        long A = line[0];
        long B = line[1];

        Set<Long> visited = new HashSet<>();
        Queue<long[]> queue = new ArrayDeque<>();

        visited.add(A);
        queue.offer(new long[] { A, 1 });

        long ans = -1;

        while (!queue.isEmpty()) {
            long[] tuple = queue.poll();
            long num = tuple[0];
            long cnt = tuple[1];
            if (num == B) {
                ans = cnt;
                break;
            }
            if (2*num <= B && !visited.contains(2*num)) {
                visited.add(2*num);
                queue.offer(new long[] {2*num, cnt + 1});
            }
            if (10*num+ 1 <= B && !visited.contains(10*num+ 1)) {
                visited.add(10*num + 1);
                queue.offer(new long[] {10*num + 1, cnt + 1});
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
