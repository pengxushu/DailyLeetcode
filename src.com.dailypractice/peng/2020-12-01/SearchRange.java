import java.util.ArrayList;
import java.util.List;

public class SearchRange {

    public static void main(String[] args) {
        SearchRange sr = new SearchRange();
        int[] nums = {1};
        int target = 1;
        System.out.println(sr.searchRange(nums, target));
    }

    public int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        int[] res = {-1,-1};
        int index = 0;
        if(length == 0){
            return res;
        }
        if(target < nums[0]){
            return res;
        }
        if(target >nums[length -1]){
            return res;
        }
        int start = 0;
        int end = length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]){
                end = mid-1;
                //start = start;
            }
            if(target >nums[mid]){
                start = mid+1;
                // end = end;
            }
            if(target == nums[mid]){
                index = mid;
                res[0] = index;
                res[1] = index;
                break;
            }
        }

        int temp1 = 1;
        int temp2 = 1;
        while(index-temp1 >=0 && nums[index-temp1] == target){
            res[0] = index - temp1;
            temp1++;
        }
        while(index+temp2 < length && nums[index+temp2] == target){
            res[1] = index+temp2;
            temp2++;
        }
        return res;
    }
}
