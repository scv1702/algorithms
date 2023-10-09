package scv1702.easy;

public class ReverseBits {
    public int reverseBits(int n) {
        int size = 32;
        for (int i = 0; i < size / 2; i++) {
            int mask = 0;
            if ((1 & (n >>> i)) == 1) {
                mask |= 1 << (size - 1 - i);
            }
            if ((1 & (n >>> (size - 1 - i))) == 1) {
                mask |= 1 << i;
            }
            n &= ~(1 << i);
            n &= ~(1 << (size - 1 - i));
            n |= mask;
        }
        return n;
    }
}
