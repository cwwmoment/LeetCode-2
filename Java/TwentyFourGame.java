/**
 * Created on 19 Nov 2018 by happygirlzt
 *
 * LeetCode #679. 24 Game
 *
 */

public class TwentyFourGame {

    boolean res = false;

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for (int n : nums) {
            list.add((double) n);
        }

        helper(list);
        return res;
    }

    private void helper(List<Double> list) {
        if (res) return;

        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < 0.001) {
                res = true;
            } else {
                return;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                List<Double> next = new ArrayList<>();
                double p1 = list.get(i), p2 = list.get(j);

                next.addAll(Arrays.asList(p1 + p2, p1 - p2, p2 - p1, p1 * p2));

                if (Math.abs(p2) > 0.001) next.add(p1 / p2);
                if (Math.abs(p1) > 0.001) next.add(p2 / p1);

                list.remove(i);
                list.remove(j);

                for (Double n : next) {
                    list.add(n);
                    helper(list);
                    list.remove(list.size() - 1);
                }

                list.add(j, p2);
                list.add(i, p1);
            }
        }
    }
}
