#include <vector>
#include <iostream>

using namespace std; // Per user request

/**
 * @brief Rearranges the array such that positive and negative integers alternate,
 * preserving the original relative order of elements with the same sign.
 * * @param nums The input array with an equal number of positive and negative integers.
 * @return vector<int> The rearranged array.
 */
vector<int> rearrangeArray(const vector<int>& nums) {
    int n = nums.size();
    // Create the result array of the same size.
    vector<int> result(n);

    // 'pos_index' tracks the next available position for a positive number (0, 2, 4, ...)
    int pos_index = 0;
    
    // 'neg_index' tracks the next available position for a negative number (1, 3, 5, ...)
    int neg_index = 1;

    // Use 'start' as the loop index to iterate through the original array 'nums'.
    for (int start = 0; start < n; ++start) {
        
        if (nums[start] > 0) {
            // Case 1: Current element is positive
            // Place it at the next available positive index (0, 2, 4, ...)
            result[pos_index] = nums[start];
            
            // Move the positive index two steps forward for the next positive number
            pos_index += 2;
        } else {
            // Case 2: Current element is negative
            // Place it at the next available negative index (1, 3, 5, ...)
            result[neg_index] = nums[start];
            
            // Move the negative index two steps forward for the next negative number
            neg_index += 2;
        }
    }

    return result;
}

// Helper function for example execution
void printVector(const vector<int>& nums) {
    cout << "[";
    for (size_t i = 0; i < nums.size(); ++i) {
        cout << nums[i];
        if (i < nums.size() - 1) {
            cout << ", ";
        }
    }
    cout << "]";
}

int main() {
    // Example 1
    vector<int> nums1 = {3, 1, -2, -5, 2, -4};
    vector<int> result1 = rearrangeArray(nums1);
    cout << "Input 1: ";
    printVector(nums1);
    cout << " -> Output: ";
    printVector(result1); // Expected: [3, -2, 1, -5, 2, -4]
    cout << endl;

    // Example 2
    vector<int> nums2 = {-1, 1};
    vector<int> result2 = rearrangeArray(nums2);
    cout << "Input 2: ";
    printVector(nums2);
    cout << " -> Output: ";
    printVector(result2); // Expected: [1, -1]
    cout << endl;

    return 0;
}