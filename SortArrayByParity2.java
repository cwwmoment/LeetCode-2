public class SortArrayByParity2 {
    public int[] sortArrayByParityII(int[] A) {
        int len = A.length;
        if (len == 0 || len == 1) return A;

        int left = 0, right = 1;

        while (left < len && right < len) {
            if (A[left] % 2 != 0) {
                while (A[right] % 2 != 0) {
                    right += 2;
                }

                exchange(A, left, right);
            }

            left += 2;
        }

        return A;
    }

    public void exchange(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
