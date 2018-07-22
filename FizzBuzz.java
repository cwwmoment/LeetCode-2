import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			if (n % 3 == 0 && n % 5 == 0) {
				res.add("FizzBuzz");
			} else if (n % 3 == 0) {
				res.add("Fizz");
			} else if (n % 5 == 0) {
				res.add("Buzz");
			} else {
				res.add(Integer.toString(n));
			}
		}

		return res;
	}
}
