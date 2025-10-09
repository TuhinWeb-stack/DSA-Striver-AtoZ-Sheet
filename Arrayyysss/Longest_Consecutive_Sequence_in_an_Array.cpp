#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>

// Always use namespace std as requested.
using namespace std;

int longestConsecutive(vector<int>& nums) {
    // An empty array has no sequences.
    if (nums.empty()) {
        return 0;
    }

    // 1. Create a hash set for fast O(1) average time lookups.
    // The constructor efficiently inserts all elements from the vector.
    unordered_set<int> num_set(nums.begin(), nums.end());

    int longest_streak = 0;

    // 2. Iterate through each unique number in the set.
    for (int num : num_set) {
        // 3. The key optimization: only start counting if 'num' is the
        // beginning of a sequence. A number is a beginning if the number
        // just before it (num - 1) is NOT in the set.
        if (num_set.find(num - 1) == num_set.end()) {
            int current_num = num;
            int current_streak = 1;

            // 4. If it's a starting number, count upwards as long as
            // the next consecutive number exists in the set.
            while (num_set.find(current_num + 1) != num_set.end()) {
                current_num += 1;
                current_streak += 1;
            }

            // 5. Update the longest streak found so far.
            longest_streak = max(longest_streak, current_streak);
        }
    }

    return longest_streak;
}

// Helper function to print the result
void test(vector<int>& nums, int expected) {
    int result = longestConsecutive(nums);
    cout << "Input: [";
    for(size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i] << (i == nums.size() - 1 ? "" : ",");
    }
    cout << "], Output: " << result << (result == expected ? " (Correct)" : " (Incorrect)") << endl;
}

int main() {
    // Example 1
    vector<int> nums1 = {100, 4, 200, 1, 3, 2};
    test(nums1, 4);

    // Example 2
    vector<int> nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    test(nums2, 9);

    // Example 3
    vector<int> nums3 = {1, 0, 1, 2};
    test(nums3, 3);
    
    return 0;
}