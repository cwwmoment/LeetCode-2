/**
 * Created on 13 Apr 2019 by happygirlzt
 *
 * LeetCode #478. Generate Random Point in a Circle
 *
 */

class Solution {

    private double radius;
    private double x_center, y_center;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double x0 = x_center - radius;
        double y0 = y_center - radius;

        while (true) {
            double x = x0 + Math.random() * radius * 2;
            double y = y0 + Math.random() * radius * 2;
            if ((x - x_center) * (x - x_center) + (y - y_center) * (y - y_center) <= radius * radius) {
                return new double[]{x, y};
            }
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
