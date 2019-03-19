/**
 * Created on 13 Nov 2018 by happygirlzt
 *
 * LeetCode #929. Unique Email Addresses
 *
 */

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            set.add(modify(s));
        }

        return set.size();
    }

    public String modify(String e) {
        StringBuilder sb = new StringBuilder();
        char[] ce = e.toCharArray();

        boolean atflag = false;
        boolean plusflag = false;
        for (char c : ce) {
            if (!atflag && !plusflag) {
                if (c == '+') {
                    plusflag = true;
                    continue;
                } else if (c == '.') {
                    continue;
                } else if (c == '@') {
                    atflag = true;
                    continue;
                } else {
                    sb.append(c);
                }
            } else if (plusflag && !atflag) {
                if (c == '@') {
                    atflag = true;
                    continue;
                } else continue;
            } else if (plusflag && atflag) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    // Other's solution
    public int numUniqueEmails1(String[] emails) {
        HashSet<String> modified = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");
            String[] local = parts[0].split("\\+");
            modified.add(local[0].replace(".", "") + "@" + parts[1]);
        }

        return modified.size();
    }

    // Updated on 19 Mar 2019
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String mail : emails) {
            set.add(modify(mail));
        }

        return set.size();
    }

    private String modify(String email) {
        String[] addresses = email.split("@");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < addresses[0].length(); i++) {
            if (addresses[0].charAt(i) == '+') break;
            if (addresses[0].charAt(i) == '.') continue;
            sb.append(addresses[0].charAt(i));
        }

        sb.append('@');
        sb.append(addresses[1]);
        return sb.toString();
    }
}
