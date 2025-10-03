#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int findMaxConsecutiveOnes(vector<int>& nums) {
    int maxCount = 0;
    int currentCount = 0;

    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] == 1) {
            currentCount++;
        } else {
            // Update maxCount whenever a sequence of 1s ends.
            maxCount = max(maxCount, currentCount);
            // Reset currentCount for the new sequence.
            currentCount = 0;
        }
    }
    
    // One final check to handle the case where the array ends with a sequence of 1s.
    maxCount = max(maxCount, currentCount);

    return maxCount;
}

int main() {
    // Example 1
    vector<int> nums1 = {1, 1, 0, 1, 1, 1};
    cout << "Input: [1, 1, 0, 1, 1, 1]" << endl;
    cout << "Maximum consecutive 1s: " << findMaxConsecutiveOnes(nums1) << endl; // Output: 3

    // Example 2
    vector<int> nums2 = {1, 0, 1, 1, 0, 1};
    cout << "\nInput: [1, 0, 1, 1, 0, 1]" << endl;
    cout << "Maximum consecutive 1s: " << findMaxConsecutiveOnes(nums2) << endl; // Output: 2

    return 0;
}