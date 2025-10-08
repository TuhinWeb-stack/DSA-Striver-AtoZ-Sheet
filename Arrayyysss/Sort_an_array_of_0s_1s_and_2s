#include <iostream>
#include <vector>
#include <algorithm> // Required for std::swap

using namespace std; // Per user request

/**
 * @brief Sorts an array containing 0s, 1s, and 2s in-place.
 * * Uses the three-pointer (Dutch National Flag) approach.
 * 'start' is used for 'low' and 'end' is used for 'high' per user request.
 * * @param nums The vector of integers (0, 1, or 2) to be sorted.
 */
void sortColors(vector<int>& nums) {
    // 'start' points to the position after the last known 0.
    int start = 0; 
    
    // 'end' points to the position before the first known 2.
    int end = nums.size() - 1; 
    
    // 'current' is the main iterator.
    int current = 0; 

    while (current <= end) {
        if (nums[current] == 0) {
            // Found a 0 (Red). Swap it with the element at 'start'.
            // The element swapped into nums[current] is already known (1) or will be re-checked.
            swap(nums[current], nums[start]);
            start++;
            current++; // We can advance 'current' safely.
        } else if (nums[current] == 2) {
            // Found a 2 (Blue). Swap it with the element at 'end'.
            // The element swapped into nums[current] is UNKNOWN, so we must re-check it.
            swap(nums[current], nums[end]);
            end--;
            // DO NOT advance 'current' here.
        } else { // nums[current] == 1 (White)
            // Found a 1. It is in the correct place, so just advance the iterator.
            current++;
        }
    }
}

// Helper function to print the vector
void printVector(const vector<int>& nums) {
    cout << "[";
    for (size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i];
        if (i < nums.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]" << endl;
}

int main() {
    // Example 1
    vector<int> nums1 = {2, 0, 2, 1, 1, 0};
    cout << "Input 1: ";
    printVector(nums1);
    
    sortColors(nums1);
    
    cout << "Output 1: ";
    printVector(nums1); // Expected: [0, 0, 1, 1, 2, 2]
    
    // ---
    
    // Example 2
    vector<int> nums2 = {2, 0, 1};
    cout << "\nInput 2: ";
    printVector(nums2);
    
    sortColors(nums2);
    
    cout << "Output 2: ";
    printVector(nums2); // Expected: [0, 1, 2]

    return 0;
}