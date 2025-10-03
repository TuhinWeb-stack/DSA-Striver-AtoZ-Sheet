#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

// The function to find the missing number using the Bitwise XOR method.
int missingNumber(vector<int>& nums) {
    // n is the size of the array, and the range of numbers is [0, n].
    int n = nums.size();
    
    // We initialize 'missing' with 'n' because 'n' could be the missing number.
    // This variable will accumulate the XOR of all numbers.
    int missing = n;

    // Loop through the array from index 0 to n-1.
    for (int i = 0; i < n; ++i) {
        // XOR the 'missing' variable with the current index 'i'
        // and the number at that index 'nums[i]'.
        // This process pairs up all the numbers in the range [0, n-1] with
        // the numbers in the array.
        // For example, if '2' is at index '2', then '2 ^ 2' will be 0.
        missing ^= i;
        missing ^= nums[i];
    }
    
    // After the loop, the numbers that were present in both the range
    // and the array cancel each other out (x^x=0), leaving only the
    // number that was missing from the array.
    return missing;
}

int main() {
    // Example 1: nums = [3, 0, 1]
    vector<int> nums1 = {3, 0, 1};
    cout << "Input: nums = [3, 0, 1]" << endl;
    cout << "The missing number is: " << missingNumber(nums1) << endl;

    // Example 2: nums = [0, 1]
    vector<int> nums2 = {0, 1};
    cout << "\nInput: nums = [0, 1]" << endl;
    cout << "The missing number is: " << missingNumber(nums2) << endl;

    // Example 3: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
    vector<int> nums3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
    cout << "\nInput: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]" << endl;
    cout << "The missing number is: " << missingNumber(nums3) << endl;

    return 0;
}