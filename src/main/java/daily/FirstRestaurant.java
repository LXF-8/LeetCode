package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LXF
 * @date 2022/3/14
 */
public class FirstRestaurant {

    public static String[] findRestaurant(String[] list1, String[] list2) {
        // 将list1中的值放到map中  值 索引值
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> ans = new ArrayList<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (i + map.get(list2[i]) == minIndex) {
                    ans.add(list2[i]);
                } else if (i + map.get(list2[i]) < minIndex) {
                    minIndex = i + map.get(list2[i]);
                    ans.clear();
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"Shogun","Tapioca Express","Burger King","KFC"};
        FirstRestaurant.findRestaurant(list1, list2);
    }
}
