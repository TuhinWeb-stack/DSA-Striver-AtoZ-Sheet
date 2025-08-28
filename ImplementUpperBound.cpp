#include <iostream>
#include <vector>
using namespace std;

int upperBound(const vector<int>& nums, int x) {
    int n = nums.size();
    int start = 0;
    int end = n - 1;
    int ans = n; // Initialize 'ans' to the size of the array

    while (start <= end) {
        int mid = start + (end - start) / 2;

        // Check if nums[mid] is a potential answer.
        // The only change is the ">" operator.
        if (nums[mid] > x) {
            ans = mid;
            // Try to find a smaller index that also satisfies the condition.
            end = mid - 1;
        } else {
            // The value is too small, so search in the right half.
            start = mid + 1;
        }
    }

    return ans;
}

int main() {
    vector<int> nums1 = {1, 2, 2, 3};
    int x1 = 2;
    int index1 = upperBound(nums1, x1);
    cout << "Input: nums = [1, 2, 2, 3], x = 2" << endl;
    cout << "Output: " << index1 << " (index is 3)" << endl;
    cout << "Result is correct: " << (index1 == 3 ? "true" : "false") << endl;
    cout << endl;
    
    vector<int> nums2 = {1, 2, 2, 3, 5, 8};
    int x2 = 4;
    int index2 = upperBound(nums2, x2);
    cout << "Input: nums = [1, 2, 2, 3, 5, 8], x = 4" << endl;
    cout << "Output: " << index2 << " (index is 4)" << endl;
    cout << "Result is correct: " << (index2 == 4 ? "true" : "false") << endl;
    cout << endl;
    
    vector<int> nums3 = {1, 2, 2, 3};
    int x3 = 5;
    int index3 = upperBound(nums3, x3);
    cout << "Input: nums = [1, 2, 2, 3], x = 5" << endl;
    cout << "Output: " << index3 << " (index is " << nums3.size() << ")" << endl;
    cout << "Result is correct: " << (index3 == nums3.size() ? "true" : "false") << endl;
    cout << endl;
    
    return 0;
}