package greedy.mergeTriplets;

public class MergeTriplets {

    public static void main(String[] args) {

        MergeTriplets solver = new MergeTriplets();

        System.out.println("Example 1:");
        System.out.println(
                solver.mergeTriplets(
                        new int[][]{{1,2,3},{7,1,1}},
                        new int[]{7,2,3}
                )
        ); // true

        System.out.println();

        System.out.println("Example 2:");
        System.out.println(
                solver.mergeTriplets(
                        new int[][]{{2,5,6},{1,4,4},{5,7,5}},
                        new int[]{5,4,6}
                )
        ); // false
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean foundX = false;
        boolean foundY = false;
        boolean foundZ = false;

        for (int[] triplet : triplets) {

            if (triplet[0] <= target[0] &&
                    triplet[1] <= target[1] &&
                    triplet[2] <= target[2]) {

                if (triplet[0] == target[0]) foundX = true;
                if (triplet[1] == target[1]) foundY = true;
                if (triplet[2] == target[2]) foundZ = true;
            }
        }

        return foundX && foundY && foundZ;
    }
}