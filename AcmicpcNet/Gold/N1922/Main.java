package AcmicpcNet.Gold.N1922;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

    private static int mst(int N, int[][] edge) {
        int M = edge.length;

        int[] rank = new int[1+N];
        int[] set = new int[1+N];
        for (int i = 1; i <= N; i++) {
            set[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p[2]));
        for (int i = 0; i < M; i++) {
            pq.offer(edge[i]);
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int a = curr[0];
            int b = curr[1];
            if (find(set, a) == find(set, b)) {
                continue;
            }
            res += curr[2];
            union(set, rank, a, b);
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] edge = new int[M][3];
        for (int i = 0; i < M; i++) {
            edge[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        int answer = mst(N, edge);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
