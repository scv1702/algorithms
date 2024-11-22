package AcmicpcNet.Gold.N20040;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static void union(int[] roots, int[] rank, int u, int v) {
        int ru = find(roots, u);
        int rv = find(roots, v);

        if (ru == rv) {
            return ;
        }

        if (rank[ru] < rank[rv]) {
            roots[ru] = rv;
        } else {
            roots[rv] = ru;
            if (rank[ru] == rank[rv]) {
                rank[ru] += 1;
            }
        }
    }

    private static int find(int[] roots, int u) {
        if (roots[u] == u) {
            return u;
        }
        return roots[u] = find(roots, roots[u]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        int[] roots = new int[N];
        int[] rank = new int[N];

        for (int i = 0; i < N; i++) {
            roots[i] = i;
            rank[i] = 1;
        }

        int ans = 0;
        for (int i = 1; i <= M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int u = line[0];
            int v = line[1];

            if (find(roots, u) == find(roots, v)) {
                ans = i;
                break;
            }

            union(roots, rank, u, v);
        }

        bw.write(String.valueOf(ans) + '\n');
        bw.flush();
        bw.close();
    }
}
