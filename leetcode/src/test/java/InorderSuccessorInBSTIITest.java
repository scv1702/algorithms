import static org.assertj.core.api.Assertions.*;

import scv1702.data.TreeNode;
import scv1702.medium.InorderSuccessorInBSTII;
import org.junit.jupiter.api.Test;

public class InorderSuccessorInBSTIITest {
    private InorderSuccessorInBSTII solution = new InorderSuccessorInBSTII();

    @Test
    public void exampleOne() {
        TreeNode root = new TreeNode(2);
        root.addLeft(1); root.addRight(3);
        assertThat(solution.findInorderSuccessor(root.left).val).isEqualTo(2);
    }

    @Test
    public void exampleTwo() {
        TreeNode root = new TreeNode(5);
        root.addLeft(3).addLeft(2).addLeft(1);
        root.addRight(6);
        root.left.addRight(4);
        assertThat(solution.findInorderSuccessor(root.right)).isEqualTo(null);
    }

    @Test
    public void exampleThree() {
        TreeNode root = new TreeNode(15);
        root.addLeft(6).addLeft(3).addLeft(2);
        root.addRight(18).addRight(20);
        root.left.addRight(7).addRight(13).addLeft(9);
        root.right.addLeft(17);
        assertThat(solution.findInorderSuccessor(root).val).isEqualTo(17);
    }

    @Test
    public void exampleFour() {
        TreeNode root = new TreeNode(15);
        root.addLeft(6).addLeft(3).addLeft(2);
        root.addRight(18).addRight(20);
        root.left.addRight(7).addRight(13).addLeft(9);
        root.right.addLeft(17);
        assertThat(solution.findInorderSuccessor(root.left.right.right).val).isEqualTo(15);
    }
}