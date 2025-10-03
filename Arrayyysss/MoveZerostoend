#include <iostream>
#include <vector>
#include <algorithm> // Required for std::swap

using namespace std;

void moveZeroes(vector<int>& nums) {
    int lastNonZeroFoundAt = 0;
    
    // Iterate through the array with a 'current' pointer.
    for (int i = 0; i < nums.size(); ++i) {
        // If the current element is not zero,
        // swap it with the element at 'lastNonZeroFoundAt'.
        if (nums[i] != 0) {
            swap(nums[lastNonZeroFoundAt], nums[i]);
            // Increment the 'lastNonZeroFoundAt' pointer.
            lastNonZeroFoundAt++;
        }
    }
}

int main() {
    // Example 1
    vector<int> nums1 = {0, 1, 0, 3, 12};
    cout << "Original array: ";
    for (int num : nums1) {
        cout << num << " ";
    }
    cout << endl;
    
    moveZeroes(nums1);
    
    cout << "Array after moving zeroes: ";
    for (int num : nums1) {
        cout << num << " ";
    }
    cout << endl;
    
    // Example 2
    vector<int> nums2 = {0};
    cout << "\nOriginal array: ";
    for (int num : nums2) {
        cout << num << " ";
    }
    cout << endl;
    
    moveZeroes(nums2);
    
    cout << "Array after moving zeroes: ";
    for (int num : nums2) {
        cout << num << " ";
    }
    cout << endl;

    return 0;
}