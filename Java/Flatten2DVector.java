/**
 * Created on 6 Jan 2019 by happygirlzt
 *
 * LeetCode #251. Flatten 2D Vector
 *
 */

public class Vector2D implements Iterator<Integer> {

    private Iterator<List<Integer>> rowIter;
    private Iterator<Integer> colIter;

    public Vector2D(List<List<Integer>> vec2d) {
        rowIter = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return colIter.next();
    }

    @Override
    public boolean hasNext() {
        while (((colIter == null) || !colIter.hasNext()) && rowIter.hasNext()) {
            colIter = rowIter.next().iterator();
        }

        return colIter != null && colIter.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
