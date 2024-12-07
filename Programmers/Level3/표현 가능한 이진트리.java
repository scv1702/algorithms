import java.util.*;

class Solution {

    private String toBinaryString(long number) {
        String binary = Long.toString(number, 2);
        int k = binary.length();
        int n = (int) Math.ceil(Math.log(k + 1) / Math.log(2));
        int m = (1 << n) - 1;
        return "0".repeat(m - k) + binary;
    }

    private void createTreeDfs(int[] tree, int node, Queue<Integer> queue) {
        if (2 * node < tree.length) {
            createTreeDfs(tree, 2 * node, queue);
        }

        tree[node] = queue.poll();

        if (2 * node + 1 < tree.length) {
            createTreeDfs(tree, 2 * node + 1, queue);
        }
    }

    private int[] createTree(long number) {
        String binary = toBinaryString(number);
        int n = binary.length();
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(binary.charAt(i) - '0');
        }
        int[] tree = new int[1+n];
        createTreeDfs(tree, 1, queue);
        return tree;
    }

    public boolean check(int[] tree) {
        for (int i = 2; i < tree.length; i++) {
            int parent = i / 2;
            if (tree[i] == 1 && tree[parent] == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] solution(long[] numbers) {
        int T = numbers.length;
        int[] answer = new int[T];
        for (int i = 0; i < T; i++) {
            int[] tree = createTree(numbers[i]);
            if (check(tree)) {
                answer[i] = 1;
            }
        }
        return answer;
    }
}