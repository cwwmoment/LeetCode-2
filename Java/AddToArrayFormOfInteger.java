/**
 * Created on 10 Feb 2019 by happygirlzt
 *
 * LeetCode #989. Add to Array-Form of Integer
 * 
 */

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> a = new ArrayList();
        for (int i : A) {
            a.add(i);
        }
        List<Integer> b = new ArrayList<>();
        while (K > 0) {
            b.add(0, K % 10);
            K = K / 10;
        }
        
        int i = a.size() - 1, j = b.size() - 1;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            sum += (i >= 0) ? a.get(i) : 0;
            sum += (j >= 0) ? b.get(j) : 0;
            res.add(0, sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        if (carry != 0) {
            res.add(0, carry);
        }
        
        return res;
    }

    // Others' elegant code
    public List<Integer> addToArrayForm1(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> res = new ArrayList<>();
        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0) {
                cur += A[i];
            }
            res.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}