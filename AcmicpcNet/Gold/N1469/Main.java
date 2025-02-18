package AcmicpcNet.Gold.N1469;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    private static boolean dfs(int[] X, int[] res, boolean[] visited, int count) {
        int N = X.length;

        if (count <= 0) {
            return true;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            int j = 0;
            while (j < 2 * N && res[j] >= 0) {
                j += 1;
            }
            int k = j + X[i] + 1;
            if (k >= 2 * N) continue;
            if (res[k] >= 0) continue;
            visited[i] = true;
            res[j] = res[k] = X[i];
            if (dfs(X, res, visited, count - 1)) return true;
            visited[i] = false;
            res[j] = res[k] = -1;
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] X = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] res = new int [2*N];
        boolean[] visited = new boolean[N];

        Arrays.sort(X);
        Arrays.fill(res, -1);

        String ans = "-1";
        if (dfs(X, res, visited, N)) {
            ans = Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        }

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
