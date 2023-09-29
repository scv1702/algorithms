package scv1702.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        helper(rowIndex, res);
        return res;
    }

    public void helper(int rowIndex, List<Integer> res) {
        if (rowIndex == 0) {
            res.add(1);
            return;
        }
        helper(rowIndex - 1, res);
        for (int i = res.size() - 1; i >= 1; i--) {
            res.set(i, res.get(i - 1) + res.get(i));
        }
        res.add(1);
    }
}
