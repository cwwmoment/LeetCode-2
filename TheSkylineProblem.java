/**
 * Created on 1 Oct 2018 by happygirlzt
 *
 * LeetCode #218. The Skyline Problem
 */

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] b) {
        List<int[]> res = new ArrayList<>();
        int[] r = new int[2];
        // r[0] = b[0][0];
        // r[1] = b[0][2];
        res.add(new int[]{b[0][0], b[0][2]});

        if (b.length == 0 || b[0].length == 0) return res;

        int n = b.length;
        int right = b[0][1];
        int height = b[0][2];
        for (int i = 0; i < n - 1; i++) {
            if (b[i+1][0] == b[i][0] && b[i+1][1] == b[i][1]) { // 起始值相等
                if (b[i+1][2] > height) {
                    res.remove(res.size() - 1);
                    res.add(new int[]{b[i+1][0], b[i+1][2]});
                    height = b[i+1][2];
                    right = Math.max(right, b[i+1][1]);
                } else {
                    right = Math.max(right, b[i+1][1]);
                    continue;
                }
            } else if (b[i+1][0] > right) { // 中间有间断
                //r[0] = right;
                //r[1] = 0;
                //res.add(r);
                res.add(new int[]{right, 0});
                //                r[0] = b[i+1][0];
                //r[1] = b[i+1][2];
                //                res.add(r);
                res.add(new int[]{b[i+1][0], b[i+1][2]});
                right = b[i+1][1];
                continue;
            } else if (b[i+1][2] > b[i][2]) { // 后者更高
                // r[0] = b[i+1][0];
                // r[1] = b[i+1][2];
                // res.add(r);
                res.add(new int[]{b[i+1][0], b[i+1][2]});
                right = Math.max(right, b[i+1][1]);
                continue;
            } else if (b[i+1][2] < b[i][2]) {  // 后者更低
                if (b[i+1][1] > b[i][1]) {
                    // r[0] = b[i][1];
                    // r[1] = b[i+1][2];
                    // res.add(r);
                    res.add(new int[]{b[i][1], b[i+1][2]});
                    right = Math.max(right, b[i+1][1]);

                } else {
                    continue;
                }
            } else {  // equal
                right = Math.max(right, b[i+1][1]);
                continue;
            }
        }


            // r[0] = b[i+1][1];
            // r[1] = 0;
            // res.add(r);
        res.add(new int[]{right, 0});

        return res;
    }

    // other's smart solution
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        if (buildings.length == 0 || buildings[0].length == 0) return list;

        List<int[]> height = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {
            height.add(new int[]{buildings[i][0], buildings[i][2]});
            height.add(new int[]{buildings[i][1], -buildings[i][2]});
        }

        Collections.sort(height, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2) {
           //注意这里是O2[1] - o1[0]!
               if (o1[0] == o2[0]) return o2[1] - o1[1];
               else return o1[0] - o2[0];
           }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        queue.offer(0);
        int cur = 0, pre = 0;
        for (int[] h : height) {
            if (h[1] > 0) {
                queue.offer(h[1]);
            } else {
                queue.remove(-h[1]);
            }
            cur = queue.peek();
            if (pre != cur) {
                list.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return list;
    }
}
