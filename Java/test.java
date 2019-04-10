public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int num = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // get number
            if (Character.isDigit(c)) {
                num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }

                numStack.push(num);
                num = 0;
            } else if (c == '(' || c == '[' || c == '{') {
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ')' || c == ']' || c == '}') {
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int times = numStack.pop();
                for (int j = 0; j < times; j++) {
                    tmp.append(sb);
                }

                sb = tmp;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
