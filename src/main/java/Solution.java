import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        Map<Integer, Integer> map = new HashMap<>();

        if (nums[0] == 1) {
            prefix[0] = 1;
            map.put(1, 0);
        } else {
            prefix[0] = -1;
            map.put(-1, 0);
        }
        int max = 0;
        for (int i = 1; i < n; i++) {
            int x = nums[i] == 1 ? 1 : -1;
            prefix[i] = prefix[i - 1] + x;
            if (prefix[i] == 0) {
                max = i + 1;
                continue;
            }
            if (map.containsKey(prefix[i])) {
                max = Math.max(max, i - map.get(prefix[i]));
            }
            map.putIfAbsent(prefix[i], i);
        }
        return max;
    }
}
