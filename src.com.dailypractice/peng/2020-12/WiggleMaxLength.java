public class WiggleMaxLength {
    public static void main(String[] args) {
        WiggleMaxLength wm = new WiggleMaxLength();
        int[] nums = {0,0,1};
        System.out.println(wm.wiggleMaxLength(nums));
    }

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        if (length == 2) {
            if (nums[1] - nums[0] == 0) {
                return 1;
            } else {
                return 2;
            }
        }
        int curRes = 0;
        if (nums[1] - nums[0] == 0) {
            curRes = 1;
        } else {
            curRes = 2;
        }
        int max = 0;
        int first = nums[1] - nums[0];
        for (int i = 2; i < length; i++) {
            int second = nums[i] - nums[i-1];
            if (first * second < 0) {
                curRes++;
            } else {
                if (first * second  == 0 && second !=0) {
                    first = second;
                    curRes++;
                }
                continue;
            }
            first = second;
        }
        return curRes;
    }
}
