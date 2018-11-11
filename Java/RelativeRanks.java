/**
 * Created on 11 Nov 2018 by happygirlzt
 *
 * LeetCode #506. Relative Ranks
 *
 */

public class RelativeRanks {
    // My solution
    public String[] findRelativeRanks(int[] nums) {
        //ArrayList<String> res = new ArrayList<>();
        String[] res = new String[nums.length];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        TreeMap<Integer, Integer> treemap = new TreeMap<>(Collections.reverseOrder());
        treemap.putAll(map);

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : treemap.entrySet()) {
            i++;
            if (i == 1) {
                res[entry.getValue()] = "Gold Medal";
            } else if (i == 2) {
                res[entry.getValue()] = "Silver Medal";
            } else if (i == 3) {
                res[entry.getValue()] = "Bronze Medal";
            } else {
                res[entry.getValue()] = Integer.toString(i);
            }
        }


        return res;
    }

    // Other's solution
    public String[] findRelativeRanks(int[] nums) {
        int[][] pair = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> (b[0] - a[0]));

        String[] res = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                res[pair[i][1]] = "Gold Medal";
            } else if (i == 1) {
                res[pair[i][1]] = "Silver Medal";
            } else if (i == 2) {
                res[pair[i][1]] = "Bronze Medal";
            } else {
                res[pair[i][1]] = (i + 1) + "";
            }
        }

        return res;
    }
}
