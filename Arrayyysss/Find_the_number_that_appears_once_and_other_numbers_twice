#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

// Function to find the single unique number.
int singleNumber(vector<int>& nums) {
    // We initialize the result to 0. XORing any number with 0 gives the number itself.
    int result = 0;
    
    // Iterate through each number in the array.
    for (int num : nums) {
        // The core logic: XOR each element with the running result.
        // Property of XOR: a ^ a = 0 and a ^ 0 = a.
        // Every number that appears twice will cancel itself out,
        // leaving only the unique number.
        result ^= num;
    }
    
    // The final result is the single number.
    return result;
}

int main() {
    // Example 1: Input nums = [2, 2, 1], Expected Output: 1
    vector<int> nums1 = {2, 2, 1};
    cout << "Input: [2, 2, 1]" << endl;
    cout << "Output: " << singleNumber(nums1) << endl; 

    // Example 2: Input nums = [4, 1, 2, 1, 2], Expected Output: 4
    vector<int> nums2 = {4, 1, 2, 1, 2};
    cout << "\nInput: [4, 1, 2, 1, 2]" << endl;
    cout << "Output: " << singleNumber(nums2) << endl; 

    // Example 3: Input nums = [1], Expected Output: 1
    vector<int> nums3 = {1};
    cout << "\nInput: [1]" << endl;
    cout << "Output: " << singleNumber(nums3) << endl; 

    return 0;
}