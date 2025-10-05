#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int key) {
        unordered_map<int, int> num_map;
        for (int start = 0; start < nums.size(); ++start) {
            int complement = key - nums[start];
            if (num_map.count(complement)) {
                return {num_map[complement], start};
            }
            num_map[nums[start]] = start;
        }
        return {}; // This part is not executed based on the problem constraints.
    }
};

int main() {
    Solution solution;

    // Example 1
    vector<int> nums1 = {2, 7, 11, 15};
    int key1 = 9;
    vector<int> result1 = solution.twoSum(nums1, key1);
    cout << "Example 1 Output: [" << result1[0] << ", " << result1[1] << "]" << endl;

    // Example 2
    vector<int> nums2 = {3, 2, 4};
    int key2 = 6;
    vector<int> result2 = solution.twoSum(nums2, key2);
    cout << "Example 2 Output: [" << result2[0] << ", " << result2[1] << "]" << endl;

    // Example 3
    vector<int> nums3 = {3, 3};
    int key3 = 6;
    vector<int> result3 = solution.twoSum(nums3, key3);
    cout << "Example 3 Output: [" << result3[0] << ", " << result3[1] << "]" << endl;

    return 0;
}