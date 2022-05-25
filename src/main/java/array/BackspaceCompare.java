package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 含空格的字符串
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab#c", t = "ad#c"
 * 输出：true
 * 解释：s 和 t 都会变成 "ac"。
 * 示例 2：
 * <p>
 * 输入：s = "ab##", t = "c#d#"
 * 输出：true
 * 解释：s 和 t 都会变成 ""。
 * 示例 3：
 * <p>
 * 输入：s = "a#c", t = "b"
 * 输出：false
 * 解释：s 会变成 "c"，但 t 仍然是 "b"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 200
 * s 和 t 只含有小写字母以及字符 '#'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author LXF
 * @date 2022/3/4
 */
public class BackspaceCompare {

    // 双指针法
    public static boolean backspaceCompare2(String s, String t) {
        int sPointer = s.length() - 1, tPointer = t.length() - 1;
        int sSkip = 0, tSkip = 0;
        while (sPointer >= 0 || tPointer >= 0) {
            // 找出s第一个可以比较的数
            while (sPointer >= 0) {
                if (s.charAt(sPointer) == '#') {
                    sSkip++;
                    sPointer--;
                } else if (sSkip > 0) {
                    sSkip--;
                    sPointer--;
                } else {
                    break;
                }
            }
            // 找到t第一个可以比较的数
            while (tPointer >= 0) {
                if (t.charAt(tPointer) == '#') {
                    tSkip++;
                    tPointer--;
                } else if (tSkip > 0) {
                    tSkip--;
                    tPointer--;
                } else {
                    break;
                }
            }
            // 如果第一个位置有#,会越界
            if (sPointer >= 0 && tPointer >= 0) {
                if (s.charAt(sPointer) != t.charAt(tPointer)) {
                    return false;
                }
            } else if (sPointer >= 0 || tPointer >= 0) {
                // 两个字符串第一位都是空格时，也相等
                return false;
            }
            sPointer--;
            tPointer--;
        }
        return true;
    }


    // 可以使用栈
    public static boolean backspaceCompare(String s, String t) {
        List<Character> sList = getList(s);
        List<Character> tList = getList(t);
        if (sList.size() != tList.size()) {
            return false;
        }
        for (int i = 0; i < sList.size(); i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<Character> getList(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : chars) {
            if (c == '#') {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            } else {
                list.add(c);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare2(s, t));
    }
}
