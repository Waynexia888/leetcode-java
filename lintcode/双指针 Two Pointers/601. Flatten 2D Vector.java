public class Vector2D implements Iterator<Integer> {
    List<List<Integer>> vec2d;
    int row, column;
    
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        this.vec2d = vec2d;
        row = 0;
        column = 0;
    }

    @Override
    public Integer next() {
        // Write your code here
        while (row < vec2d.size() && column == vec2d.get(row).size()) {
            row += 1;
            column = 0;
        }
        int value = vec2d.get(row).get(column);
        column++;
        return value;
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while (row < vec2d.size() && column == vec2d.get(row).size()) {
            row += 1;
            column = 0;
        }
        return row < vec2d.size();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */