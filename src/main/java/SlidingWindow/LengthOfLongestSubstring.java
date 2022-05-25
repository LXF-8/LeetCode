package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author LXF
 * @date 2022/3/11
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int winStart = 0;
        int winLen = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(winStart++));
            }
            winLen = Math.max(winLen, i - winStart + 1);
            set.add(s.charAt(i));
        }
        return winLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        //if(s==null) return 0;这句话可以不加，s.length()长度为0时，不进入下面的循环，会直接返回max=0;
        //划定当前窗口的坐标为(start,i],左开右闭,所以start的初始值为-1，而非0。
        int max = 0,start =-1;
        //使用哈希表map统计各字符最后一次出现的索引位置
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char tmp = s.charAt(i);

            //当字符在map中已经存储时，需要判断其索引值index和当前窗口start的大小以确定是否需要对start进行更新:
            //当index>start时，start更新为当前的index,否则保持不变。
            //注意若index作为新的start，计算当前滑动空间的长度时也是不计入的，左开右闭，右侧s[i]会计入，这样也是防止字符的重复计入。
            if(map.containsKey(tmp)) start = Math.max(start,map.get(tmp));

            //如果map中不含tmp，此处是在map中新增一个键值对，否则是对原有的键值对进行更新
            map.put(tmp,i);

            //i-start,为当前滑动空间(start,i]的长度，若其大于max，则需要进行更新。
            max = Math.max(max,i-start);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
    }
}
