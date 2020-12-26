package jianzhi.day1;

/**
 * 替换空格
 * <p>
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * <p>
 * 从后往前替换
 */

public class _01替换空格 {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }
}
