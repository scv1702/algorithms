package AcmicpcNet.Gold.N1043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static int find(int[] root, int i) {
        if (root[i] == i) {
            return i;
        }
        return root[i] = find(root, root[i]);
    }

    public static void union(int[] root, int a, int b) {
        int pa = find(root, a);
        int pb = find(root, b);
        if (pa == pb) return ;
        root[pb] = pa;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int N = line[0];
        int M = line[1];

        line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int T = line[0]; // 진실을 아는 사람의 수
        int[] t = Arrays.copyOfRange(line, 1, T+1); // 진실을 아는 사람

        int[] root = new int[1+N];
        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }

        for (int i = 1; i < T; i++) {
            union(root, t[i-1], t[i]);
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int P = line[0]; // 파티 수
            List<Integer> party = Arrays.stream(Arrays.copyOfRange(line, 1, P+1))
                    .boxed()
                    .collect(Collectors.toList());
            for (int j = 1; j < P; j++) {
                union(root, party.get(j-1), party.get(j));
            }
            parties.add(party);
        }

        int tr = 0;
        if (T > 0) {
            tr = find(root, t[0]);
        }
        int ans = M;

        for (int i = 0; i < M; i++) {
            List<Integer> party = parties.get(i);
            for (int j = 0; j < party.size(); j++) {
                if (find(root, party.get(j)) == tr) {
                    ans -= 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }
}
