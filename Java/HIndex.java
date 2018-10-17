import java.util.Arrays;

/**
 * LeetCode #274. H-Index Created on 2018-08-25
 * 
 * @author happygirlzt
 *
 */
public class HIndex {
	/**
	 * 这道题是求H-index的，本质上排序。因为要找到h，有n个数比h大， n-h个数比h小。可以使用桶排序
	 * 
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
		int h = 0;

		Arrays.sort(citations);

		for (int i = 0; i < citations.length; i++) {
			h = Math.max(h, Math.min(citations.length - i, citations[i]));
		}

		return h;
	}

	// Binary search
	public int hIndex1(int[] citations) {
		Arrays.sort(citations);
		int h = 0;		
		int left = 0;
		int n = citations.length;
		int right = n - 1;
		
		while (left <= right) {
			int mid = (left + right) >> 1;
		
			if (citations[mid] >= n - mid) {
                h = n - mid;
                right = mid - 1;
            } else left = mid + 1; 
		}
		
		return h;
	}

	// Bucket sort
	public int hIndex2(int[] citations) {
		int n = citations.length;
		int[] buckets = new int[n + 1];
		
		for (int c : citations) {
			if (c >= n) {
				buckets[n]++;
			} else {
				buckets[c]++;
			}
		}
		
		int count = 0;
		for (int i = n; i >= 0; i--) {
			count += buckets[i];
			if (count >= i) {
				return i;
			}
		}
		return 0;
	}
}