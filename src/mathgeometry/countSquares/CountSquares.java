package mathgeometry.countSquares;

import java.util.HashMap;
import java.util.Map;

public class CountSquares {

    // x → (y → frequency)
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public static void main(String[] args) {

        CountSquares cs = new CountSquares();

        cs.add(new int[]{1, 1});
        cs.add(new int[]{2, 2});
        cs.add(new int[]{1, 2});

        System.out.println(cs.count(new int[]{2, 1})); // 1

        cs.add(new int[]{2, 2}); // duplicate

        System.out.println(cs.count(new int[]{2, 1})); // 2
    }

    public void add(int[] point) {

        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = points.get(x);

        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {

        int x1 = point[0];
        int y1 = point[1];

        if (!points.containsKey(x1))
            return 0;

        int total = 0;

        // Get all points in same vertical line
        Map<Integer, Integer> sameColumn = points.get(x1);

        for (int y2 : sameColumn.keySet()) {

            if (y2 == y1)
                continue;  // skip same point

            int side = Math.abs(y2 - y1);

            // Try square on RIGHT side
            total += countSquare(x1, y1, x1 + side, y2);

            // Try square on LEFT side
            total += countSquare(x1, y1, x1 - side, y2);
        }

        return total;
    }

    private int countSquare(int x1, int y1, int x2, int y2) {

        if (!points.containsKey(x2))
            return 0;

        Map<Integer, Integer> columnX2 = points.get(x2);

        int countVertical = points.get(x1).getOrDefault(y2, 0);
        int countBottom = columnX2.getOrDefault(y1, 0);
        int countDiagonal = columnX2.getOrDefault(y2, 0);

        return countVertical * countBottom * countDiagonal;
    }
}