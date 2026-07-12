class Solution {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[201];

        // Count frequency
        for (int num : nums) {
            freq[num + 100]++;
        }

        // Bubble sort with custom conditions
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int f1 = freq[nums[j] + 100];
                int f2 = freq[nums[j + 1] + 100];

                if (f1 > f2 || (f1 == f2 && nums[j] < nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }
}
