package top100like.top_fast;

/**
 * Created by lanzehao on 2018/3/5.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/5 16:10
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        if(n == 0){
            throw new IllegalArgumentException("error input, nums2 is empty.");
        }
        if(m == 0){
            return n % 2 == 0 ? (nums2[n / 2 -1] + nums2[n / 2]) / 2.0 : nums2[n / 2];
        }
        int l = 0, r = m;
        while(l <= r){
            int partX = (l + r) / 2;
            int partY = (m + n + 1) / 2 - partX;

            int leftX = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int rightX = partY == m ? Integer.MAX_VALUE : nums1[partX];
            int leftY = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int rightY = partY == n ? Integer.MAX_VALUE : nums2[partY];

            if(leftX <= rightY && leftY <= rightX){
                if((m + n) % 2 == 0){
                    int res = Math.max(leftX, leftY);
                    res += Math.max(rightX, rightY);
                    return res / 2.0;
                }else
                    return Math.max(leftX,leftY);
            }else if(leftX > rightY)
                r = --partX;
            else
                l = ++partX;
        }
        return -1;
    }
}
