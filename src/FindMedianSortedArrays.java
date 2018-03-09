/**
 * Created by lanzehao on 2018/3/1.
 * <p>
 * Description：
 * <p>
 * version：1.0
 * version description：
 * update time：2018/3/1 17:18
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //m , n 为传入的左，右两个数组的长度
        int m = nums1.length, n = nums2.length;
        //若左边长于右边，则调换左右位置
        if(m > n){
            return findMedianSortedArrays(nums2, nums1);
        }
        //若右数组为零，抛出异常
        if(n == 0){
            throw new IllegalArgumentException("Illegal arguments input, num2 is empty.");
        }
        //
        int imin = 0, imax = m, half_len = (m + n + 1) / 2;

        while(imin <= imax){
            int i = (imin + imax) / 2, j = half_len - i;
            if(i < m && j > 0 && nums2[j-1] > nums1[i]){
                //i is too small, increase it
                imin = i + 1;
            }else if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
                //i is too big, decrease it
                imax = i - 1;
            }else {
                //i is perfect
                int maxLeft, minRight;
                if(i == 0) maxLeft = nums2[j-1];
                else if (j == 0) maxLeft = nums1[i - 1];
                else maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if((m + n) % 2 == 1)
                    return maxLeft;

                if(i == m) minRight = nums2[j];
                else if (j == n) minRight = nums1[i];
                else minRight = Math.min(nums1[i], nums2[j]);

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }
}
