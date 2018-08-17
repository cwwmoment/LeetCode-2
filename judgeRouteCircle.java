/*
 * LeetCode #657.Judge Route Circle
 * happygirlzt
 * Created on 15 July 2018
 * 
 */

class JudgeRouteCircle {
	// Solution 1
	static class pos {
        static int x;
        static int y;

        public pos(int a, int b) {
            x = a;
            y = b;
        }

        public void move(char c) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x++;
            } else {
                x--;
            }
        }

        static public int getX() {
            return x;
        }

        static public int getY() {
            return y;
        }
    }

    public boolean judgeCircle(String moves) {
        pos p = new pos(0, 0);
        for (int i = 0; i < moves.length(); i++) {
            p.move(moves.charAt(i));
        }

        if ((pos.getX() == 0) && (pos.getY() == 0))
            return true;
        else return false;
    }
    
    // Solution 2
    public boolean judgeCircle2(String moves) {
        int len = moves.length();

        if (len == 0)
            return true;

        if (len % 2 != 0)
            return false;

        int[] a = new int[26];

        for (int i = 0; i < len; i++) {
            int count = moves.charAt(i)-'A';
            a[count]++;
        }

        return ((a['U'-'A']==a['D'-'A'])&&(a['L'-'A']==a['R'-'A']));
    }
    
    // Solution 3
    public boolean judgeCircle3(String moves) {
        int x = 0;
        int y = 0;

        for (char ch : moves.toCharArray()) {
            if (ch == 'U') y++;
            else if (ch == 'D') y--;
            else if (ch == 'L') x++;
            else x--;
        }

        return x == 0 && y == 0;
      }
}