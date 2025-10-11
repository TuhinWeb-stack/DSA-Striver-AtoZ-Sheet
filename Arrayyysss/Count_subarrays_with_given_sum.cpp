#include <iostream>
#include <vector>
#include <unordered_map>

// As you've requested, I'll use the std namespace.
using namespace std;

/**
 * @brief Calculates the total number of continuous subarrays whose sum equals k.
 *
 * This function uses a hash map to store the frequencies of prefix sums encountered
 * so far. For each element, it calculates the cumulative sum and then checks
 * the map for the number of times `currentSum - k` has occurred previously.
 *
 * @param nums A vector of integers.
 * @param k The target sum.
 * @return The total number of subarrays summing to k.
 */
int subarraySum(vector<int>& nums, int k) {
    // A map to store {prefix_sum, frequency}
    unordered_map<int, int> prefixSumCount;
    int count = 0;
    int currentSum = 0;

    // Initialize with a prefix sum of 0 having one occurrence.
    // This handles cases where a subarray starting from index 0 sums to k.
    prefixSumCount[0] = 1;

    for (int num : nums) {
        // Calculate the current prefix sum
        currentSum += num;

        // Check if (currentSum - k) exists in the map.
        // If it does, it means there are subarrays ending at the current
        // position whose sum is k.
        if (prefixSumCount.count(currentSum - k)) {
            count += prefixSumCount[currentSum - k];
        }

        // Increment the count for the current prefix sum in the map.
        prefixSumCount[currentSum]++;
    }

    return count;
}

int main() {
    // Example 1
    vector<int> nums1 = {1, 1, 1};
    int k1 = 2;
    cout << "Input: nums = [1,1,1], k = 2" << endl;
    cout << "Output: " << subarraySum(nums1, k1) << endl; // Expected: 2

    cout << "\n--------------------------\n" << endl;

    // Example 2
    vector<int> nums2 = {1, 2, 3};
    int k2 = 3;
    cout << "Input: nums = [1,2,3], k = 3" << endl;
    cout << "Output: " << subarraySum(nums2, k2) << endl; // Expected: 2

    return 0;
}