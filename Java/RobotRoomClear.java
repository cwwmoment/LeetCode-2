/**
 * Created on 4 Dec 2018 by happygirlzt
 *
 * LeetCode #489. Robot Room Cleaner
 *
 */
public class RobotRoomClear {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        visited.add("0-0");

        dfs(robot, 0, 0, 0, visited);
    }

    // [x, y] is the relative position from the initial point
    private void dfs(Robot robot, int x, int y, int curDir, Set<String> visited) {

        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];

            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                visited.add(newX + "-" + newY);
                dfs(robot, newX, newY, nextDir, visited);
            }

            robot.turnRight();
        }

        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
