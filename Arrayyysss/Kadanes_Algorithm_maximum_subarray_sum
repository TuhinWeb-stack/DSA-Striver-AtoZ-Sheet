#include <iostream>
#include <vector>
#include <algorithm> // Required for std::max

using namespace std; // Per user request

/**
 * @brief Finds the subarray with the largest sum using Kadane's Algorithm.
 * * @param nums The input array of integers.
 * @return int The largest sum found in any subarray.
 */
int maxSubArray(const vector<int>& nums) {
    // Check for an empty array, though constraints say nums.length >= 1
    if (nums.empty()) {
        return 0;
    }

    // Initialize both maximums to the first element
    int overall_max_sum = nums[0];
    int current_max_sum = nums[0];
    
    // Using 'start' as the loop index (skipping the first element which is already processed)
    for (int start = 1; start < nums.size(); ++start) {
        
        // 1. Calculate the largest sum ending at 'start' (current_max_sum):
        // It's either the current element nums[start]
        // OR the current element added to the previous largest sum (current_max_sum + nums[start]).
        current_max_sum = max(nums[start], current_max_sum + nums[start]);
        
        // 2. Update the overall maximum sum found so far:
        overall_max_sum = max(overall_max_sum, current_max_sum);
    }
    
    return overall_max_sum;
}

// Helper function for example execution
void printResult(const vector<int>& nums) {
    int result = maxSubArray(nums);
    
    cout << "Input: [";
    for (size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i] << (i < nums.size() - 1 ? ", " : "");
    }
    cout << "]\tOutput: " << result << endl;
}

int main() {
    // Example 1
    vector<int> nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    printResult(nums1); // Expected Output: 6

    // Example 2
    vector<int> nums2 = {1};
    printResult(nums2); // Expected Output: 1

    // Example 3
    vector<int> nums3 = {5, 4, -1, 7, 8};
    printResult(nums3); // Expected Output: 23
    
    // Additional Test Case (All negative numbers)
    vector<int> nums4 = {-2, -3, -1, -5};
    printResult(nums4); // Expected Output: -1 (the largest single element)

    return 0;
}