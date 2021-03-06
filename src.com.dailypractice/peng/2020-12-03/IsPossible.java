import java.util.HashMap;
import java.util.Map;

public class IsPossible {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0) + 1;
            countMap.put(x, count);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int preEndCount = endMap.getOrDefault(x-1, 0);
                if(preEndCount > 0) {
                    countMap.put(x, count-1);
                    endMap.put(x-1, preEndCount-1);
                    endMap.put(x, endMap.getOrDefault(x,0) + 1);
                } else {
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    if (count1 > 0 &&  count2 > 0) {
                        countMap.put(x, count-1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x+2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPossible ip = new IsPossible();
        int[] n = {1,2,3,3,4,5};
        System.out.println(ip.isPossible(n));
    }
}
