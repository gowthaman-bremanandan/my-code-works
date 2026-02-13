package queue.heap.taskScheduler;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {

        char[] tasks1 = {'X', 'X', 'Y', 'Y'};
        int n1 = 4;
        System.out.println(leastInterval(tasks1, n1)); // 5

        char[] tasks2 = {'A', 'A', 'A', 'B', 'C'};
        int n2 = 3;
        System.out.println(leastInterval(tasks2, n2)); // 9
    }

    public static int leastInterval(char[] tasks, int n) {

        if (n == 0) {
            return tasks.length;
        }

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int maxCount = 1;

        // Count how many tasks have max frequency
        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }

        int formula = (maxFreq - 1) * (n + 1) + maxCount;

        return Math.max(tasks.length, formula);
    }
}
