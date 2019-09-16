public class MedianTwoArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length == 0) {
            if (nums1.length % 2 == 0)
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            else {
                return nums1[nums1.length / 2];
            }
        }

        if (nums1.length == 0) {
            if (nums2.length % 2 == 0)
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            else {
                return nums2[nums2.length / 2];
            }
        }
        int m = Math.max(nums1.length, nums2.length);
        int n = Math.min(nums1.length, nums2.length);

        int minIndex = 0, maxIndex = n, i = 0, j = 0, median = 0;
        while (minIndex < maxIndex) {
            i = (minIndex + maxIndex) / 2;
            j = (n + m + 1) / 2 - i;

            if (i < n && j > 0 && nums2[j - 1] > nums1[i])
                minIndex = i + 1;
            else if (i > 0 && j < m && nums2[j] < nums1[i - 1])
                maxIndex = i - 1;
            else {
                if (i == 0)
                    median = nums1[j - 1];
                else if (j == 0)
                    median = nums2[i - 1];
                else
                    median = Math.max(nums1[i - 1], nums2[j - 1]);
                break;
            }
        }
        if ((n + m) % 2 == 1)
            return (double) median;

        if (i == n)
            return (median + nums2[j]) / 2.0;

        if (j == m)
            return (median + nums1[i]) / 2.0;

        return (median + Math.min(nums1[i], nums2[j])) / 2.0;
    }
}
