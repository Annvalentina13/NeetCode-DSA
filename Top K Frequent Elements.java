class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];

        // Count frequencies
        for (int num : nums) {
            freq[num + 1000]++;
        }

        int[] result = new int[k];

       
        for (int i = 0; i < k; i++) {
            int maxFreq = 0;
            int index = 0;

            for (int j = 0; j < 2001; j++) {
                if (freq[j] > maxFreq) {
                    maxFreq = freq[j];
                    index = j;
                }
            }

            result[i] = index - 1000;
            freq[index] = 0; 
        }

        return result;
    }
}
