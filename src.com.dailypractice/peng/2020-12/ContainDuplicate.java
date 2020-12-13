import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
    public static void main(String[] args) {
        ContainDuplicate cp = new ContainDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(cp.containDuplicate(nums));
    }

    public boolean containDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            targetSet.add(nums[i]);
        }
        return targetSet.size() < nums.length ? true : false;
    }

}
