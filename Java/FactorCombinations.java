class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, 2);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> tmp, int n, int index) {
        if (n <= 1) {
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
            return;
        } else {
            for (int i = index; i <= n; i++) {
                if (n % i == 0) {
                    tmp.add(i);
                    helper(res, tmp, n / i, i);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }
}