package AcmicpcNet.Gold.N1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static void union(int[] set, int[] rank, int a, int b) {
        int x = find(set, a);
        int y = find(set, b);

        if (x == y) return ;

        if (rank[x] < rank[y]) {
            set[x] = y;
        } else if (rank[x] == rank[y]) {
            set[x] = y;
            rank[y] += 1;
        } else if (rank[x] > rank[y]) {
            set[y] = x;
        }
    }

    private static int find(int[] set, int a) {
        if (set[a] == a) return a;
        return set[a] = find(set, set[a]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[] set = new int[1+N];
        for (int i = 0; i <= N; i++) {
            set[i] = i;
        }

        int[] rank = new int[1+N];

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int command = line[0];
            int a = line[1];
            int b = line[2];
            if (command == 0) {
                union(set, rank, a, b);
            }
            if (command == 1) {
                if (find(set, a) == find(set, b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
