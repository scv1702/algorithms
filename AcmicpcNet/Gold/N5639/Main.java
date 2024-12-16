package AcmicpcNet.Gold.N5639;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static int[] recur(int[] preorder, int start, int end) {
        if (start >= end) {
            return new int[0];
        }

        int[] postorder = new int[end - start];
        int root = preorder[start];
        postorder[postorder.length - 1] = root;

        int idx = end;
        for (int i = start + 1; i < end; i++) {
            if (preorder[i] > root) {
                idx = i;
                break;
            }
        }

        int[] L = recur(preorder, start + 1, idx);
        int[] R = recur(preorder, idx, end);

        for (int i = 0; i < L.length; i++) {
            postorder[i] = L[i];
        }

        for (int i = 0; i < R.length; i++) {
            postorder[L.length + i] = R[i];
        }

        return postorder;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        String line = br.readLine();

        while (!"".equals(line) && line != null) {
            list.add(Integer.parseInt(line));
            line = br.readLine();
        }

        int[] preorder = list.stream()
            .mapToInt(a -> a)
            .toArray();

        int N = preorder.length;
        int[] postorder = recur(preorder, 0, N);

        String ans = Arrays.stream(postorder)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining("\n"));

        bw.write(ans);
        bw.flush();
        bw.close();
    }
}
