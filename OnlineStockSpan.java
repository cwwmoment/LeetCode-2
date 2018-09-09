
/**
 * 
 * Created by happygirlzt on 9 Sep 2018 at 10:04:05 AM
 *
 */
import java.util.ArrayList;

public class OnlineStockSpan {
	static class StockSpanner {
	    static ArrayList<Integer> list;
	    static ArrayList<Integer> less;
	    
		public StockSpanner() {
			list = new ArrayList<>();
			less = new ArrayList<>();
		}

		public int next(int price) {
			list.add(price);
			int count = 1;
			for (int i = 0; i < list.size() - 1; i++) {
				if (list.get(i) <= price) {
					count++;
				} else {
					count = 1;
				}
			}
			
			return count;
		}
	}

}
