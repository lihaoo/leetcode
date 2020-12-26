package leetcode;

public class _461汉明距离 {
    public int hammingDistance(int x, int y) {
        int a = x^y;
        int b = 0;
        for (int i = 0; i < 32; i++) {
            if(a>>1%2==1){
                b++;
            }
        }

        return b;
    }
}
