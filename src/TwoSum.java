import java.util.HashMap;
import java.util.Map;

/**
 * Created by lanzehao on 2018/3/5.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/5 14:20
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            }
          map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No matched solution");
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        System.out.println(twoSum(nums,target).toString());

    }
}
