package scv1702.medium;

public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        int mid = (int) Math.pow(2, n - 2);
        if (k <= mid)
            return kthGrammar(n - 1, k);
        int i = (int) Math.ceil(k / 2.0);
        if (k % 2 == 0)
            return kthGrammar(n - 1, i) == 1 ? 0 : 1;
        return kthGrammar(n - 1, i);
    }
}
