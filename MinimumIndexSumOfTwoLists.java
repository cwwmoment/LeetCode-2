/**
 * Created on 21 Sep 2018 by happygirlzt
 *
 * LeetCode #599. Minimum Index Sum of Two Lists
 */

public class MinimumIndexSumOfTwoLists {
    // My naive solution
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] res = new String[1000];
        LinkedList<Integer> list = new LinkedList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int min = list1.length + list2.length;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                if (j + map.get(list2[j]) < min) {
                    // 注意这里，min的值要更新！！！
                    min = j + map.get(list2[j]);
                    list.clear();
                    list.add(j);
                } else if (j + map.get(list2[j]) == min) {
                    list.add(j);
                }
            }
        }

        int len = list.size();
        for (int i = 0; i < len; i++) {
            int index = list.get(i);
            res[i] = list2[index];
        }

        String[] r = new String[len];
        System.arraycopy(res, 0, r, 0, len);

        return r;
    }

    // 稍稍优化版
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    res.clear();
                    minSum = i + j;
                }

                res.add(list2[i]);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
