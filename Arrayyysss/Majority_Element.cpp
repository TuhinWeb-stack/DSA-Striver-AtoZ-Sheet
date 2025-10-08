#include <iostream>
#include <vector>
#include <algorithm> 

using namespace std; // Per user request

/**
 * @brief Finds the majority element using the Boyer-Moore Voting Algorithm.
 * * Added 'const' to the signature because the input array is not modified.
 * @param nums The input array where the majority element is guaranteed to exist.
 * @return int The majority element.
 */
int majorityElement(const vector<int>& nums) { // <-- FIX IS HERE: ADDED 'const'
    // We'll use 'key' (user alias for target) as the candidate for the majority element
    int key = 0;       
    int count = 0; // This tracks the "votes" for the current 'key' candidate

    for (int num : nums) {
        if (count == 0) {
            // If count is 0, elect the current element as the new candidate ('key')
            key = num;
        }
        
        if (num == key) {
            // If the current number matches the candidate, increment the count
            count++;
        } else {
            // If the current number is different, decrement the count (it "cancels out" a vote)
            count--;
        }
    }
    
    return key;
}

// Helper function for example execution
void printResult(const vector<int>& nums) {
    int result = majorityElement(nums);
    
    cout << "Input: [";
    for (size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i] << (i < nums.size() - 1 ? ", " : "");
    }
    cout << "]\tOutput: " << result << endl;
}

int main() {
    // Example 1
    vector<int> nums1 = {3, 2, 3};
    printResult(nums1);

    // Example 2
    vector<int> nums2 = {2, 2, 1, 1, 1, 2, 2};
    printResult(nums2);

    // Additional Example
    vector<int> nums3 = {6, 5, 5};
    printResult(nums3);

    return 0;
}