import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import scv1702.data.TreeNode;
import scv1702.medium.InorderSuccessorInBSTII;

public class InorderSuccessorInBSTIITest {

    private InorderSuccessorInBSTII solution = new InorderSuccessorInBSTII();

    @Test
    public void withOneNode() {
        assertNull(solution.findInorderSuccessor(new TreeNode(1)));
    }

    @Test
    public void withTwoNodes() {
        TreeNode root = new TreeNode(2);
        root.addLeft(1);
        assertEquals(2, solution.findInorderSuccessor(root.left).val);
    }

    @Test
    public void withFourNodes() {
        TreeNode root = new TreeNode(2);
        root.addLeft(1);
        root.addRight(4).addRight(6).addLeft(5);
        assertEquals(4, solution.findInorderSuccessor(root).val);
    }

    @Test
    public void withTargetNodeARightNode() {
        TreeNode root = new TreeNode(6);
        root.addLeft(4).addRight(5);
        assertEquals(6, solution.findInorderSuccessor(root.left.right).val);
    }

    @Test
    public void withTargetNodeARightNode_AndWithChild() {
        TreeNode root = new TreeNode(8);
        root.addLeft(4).addRight(6).addRight(7);
        assertEquals(7, solution.findInorderSuccessor(root.left.right).val);
    }

    @Test
    public void withTargetNodeADeepRightNode() {
        TreeNode root = new TreeNode(8);
        root.addLeft(1).addRight(2).addRight(3).addRight(4);
        assertEquals(8, solution.findInorderSuccessor(root.left.right.right.right).val);
    }
}