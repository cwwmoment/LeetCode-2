public class MinimumAddToMakeParenthesesValid {
    public int minAddToMakeValid(String S) {
        int res = 0;

        Stack<Character> st = new Stack<>();
        char[] cs = S.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '(') {
                st.push(cs[i]);
            } else if (cs[i] == ')' && st.isEmpty()) {
                res++;
            } else if (cs[i] == ')' && st.peek() == '(') {
                st.pop();
            }
        }

        res += st.size();

        return res;
    }
}
