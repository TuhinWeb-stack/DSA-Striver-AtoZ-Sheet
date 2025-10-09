#include <iostream>
#include <vector>
#include <algorithm>

// Always use namespace std as requested.
using namespace std;

void nextPermutation(vector<int>& nums) {
    int n = nums.size();
    if (n <= 1) {
        return; // A permutation is not possible for arrays with 0 or 1 element.
    }

    // Step 1: Find the first element from the right that is smaller than the element to its right.
    // This element is called the pivot.
    int pivot_index = -1;
    for (int i = n - 2; i >= 0; --i) {
        if (nums[i] < nums[i + 1]) {
            pivot_index = i;
            break;
        }
    }

    // If no such element is found, the array is the last permutation (sorted in descending order).
    // The next permutation is the first one (sorted in ascending order).
    if (pivot_index == -1) {
        reverse(nums.begin(), nums.end());
        return;
    }

    // Step 2: Find the smallest element to the right of the pivot that is greater than the pivot.
    for (int i = n - 1; i > pivot_index; --i) {
        if (nums[i] > nums[pivot_index]) {
            // Step 3: Swap the pivot with this element.
            swap(nums[pivot_index], nums[i]);
            break;
        }
    }

    // Step 4: Reverse the sub-array to the right of the pivot's original position.
    // This ensures that the new permutation is the smallest possible one.
    reverse(nums.begin() + pivot_index + 1, nums.end());
}

// Helper function to print the vector
void printVector(const vector<int>& nums) {
    cout << "[";
    for (int i = 0; i < nums.size(); ++i) {
        cout << nums[i] << (i == nums.size() - 1 ? "" : ",");
    }
    cout << "]" << endl;
}

int main() {
    // Example 1
    vector<int> nums1 = {1, 2, 3};
    nextPermutation(nums1);
    cout << "Example 1 Output: ";
    printVector(nums1); // Expected: [1,3,2]

    // Example 2
    vector<int> nums2 = {3, 2, 1};
    nextPermutation(nums2);
    cout << "Example 2 Output: ";
    printVector(nums2); // Expected: [1,2,3]

    // Example 3
    vector<int> nums3 = {1, 1, 5};
    nextPermutation(nums3);
    cout << "Example 3 Output: ";
    printVector(nums3); // Expected: [1,5,1]

    return 0;
}