public class FlippingAnImage {
    public static int[][] rev(int[][] a) {

        int len = a.length;  // rows
        int leng = a[0].length;  // columns


        for(int i = 0; i < len; i++) {
            for (int j = 0; j < leng/2; j++) {
                int tmp = a[i][j];
                a[i][j] = a[i][leng-j-1];
                a[i][leng-j-1] = tmp;
            }
        }

        return a;
    }

    public static int[][] flipAndInvertImage0(int[][] A) {

        A = rev(A);
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 0) A[i][j] = 1;
                else A[i][j] = 0;
            }
        }

        return A;
    }

    // Solution 2
    public int[][] flipAndInvertImage2(int[][] A) {
        int len = A.length;
        int leng = A[0].length;

        for(int i = 0; i < len; i ++) {
            if (leng % 2 != 0) A[i][leng/2] = A[i][leng/2]== 0 ? 1 : 0;

            for (int j = 0; j < leng/2; j++) {
                int tmp = A[i][leng-j-1] == 0 ? 1 : 0;
                A[i][leng-j-1] = A[i][j] == 0 ? 1 : 0;
                A[i][j] = tmp;
            }
        }

        return A;
    }


    // Solution 3
    public int[][] flipAndInvertImage3(int[][] A) {
        int n = A[0].length;

        for (int[] row : A) {
            for (int i = 0; i < (n+1)/2; i++) {
                int tmp = row[n-i-1] ^ 1;
                row[n-i-1] = row[i] ^ 1;
                row[i] = tmp;
            }
        }

        return A;
    }

    // Updated on 19 Mar 2019
    public int[][] flipAndInvertImage(int[][] A) {
        for (int[] row: A) {
            reverse(row);
            flip(row);
        }

        return A;
    }

    private void flip(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
    }

    private void reverse(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
