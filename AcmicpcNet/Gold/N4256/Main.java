package AcmicpcNet.Gold.N4256;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static int find(List<Integer> arr, int n) {
        int N = arr.size();
        for (int i = 0; i < N; i++) {
            if (arr.get(i) == n) return i;
        }
        return -1;
    }

    private static List<Integer> postorder(
        List<Integer> preorder,
        List<Integer> inorder
    ) {
        if (preorder.isEmpty() && inorder.isEmpty()) {
            return List.of();
        }
        if (preorder.isEmpty()) {
            return inorder;
        }
        if (inorder.isEmpty()) {
            return preorder;
        }

        int N = preorder.size();
        int root = preorder.get(0);
        int idx = find(inorder, root);

        List<Integer> res = new ArrayList<>();

        if (idx >= 0) {
            List<Integer> leftOfPreorder = preorder.subList(1, idx+1);
            List<Integer> rightOfPreorder = preorder.subList(idx+1, N);
            List<Integer> leftOfInorder = inorder.subList(0, idx);
            List<Integer> rightOfInorder = inorder.subList(idx+1, N);
            res.addAll(postorder(leftOfPreorder, leftOfInorder));
            res.addAll(postorder(rightOfPreorder, rightOfInorder));
        }

        res.add(root);

        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 노드 개수
            List<Integer> preorder = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            List<Integer> inorder = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            List<Integer> postorder = postorder(preorder, inorder);
            String res = postorder.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
            bw.write(String.format("%s\n", res));
        }

        bw.flush();
        bw.close();
    }
}
