package slidingWindow.minimumWindowSubstring;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        MinimumWindowSubstring solver = new MinimumWindowSubstring();

        System.out.println("Example 1:");
        System.out.println(
                solver.minWindow("OUZODYXAZV", "XYZ")
        ); // YXAZ

        System.out.println("Example 2:");
        System.out.println(
                solver.minWindow("xyz", "xyz")
        ); // xyz

        System.out.println("Example 3:");
        System.out.println(
                solver.minWindow("x", "xy")
        ); // ""
    }

    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        int[] targetFreq = new int[128];
        int[] windowFreq = new int[128];

        for (char c : t.toCharArray()) {
            targetFreq[c]++;
        }

        int left = 0;
        int matched = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char current = s.charAt(right);
            windowFreq[current]++;

            if (targetFreq[current] > 0 &&
                    windowFreq[current] <= targetFreq[current]) {
                matched++;
            }

            while (matched == t.length()) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                windowFreq[leftChar]--;

                if (targetFreq[leftChar] > 0 &&
                        windowFreq[leftChar] < targetFreq[leftChar]) {
                    matched--;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
    }
}