#include <iostream>
#include <string>
#include <vector>

using namespace std;

/**
 * Given two strings s and goal, determine if s can become goal after 
 * some number of shifts (rotations) on s.
 */
class Solution {
public:
    bool rotateString(string s, string goal) {
        // Step 1: Check Lengths. If lengths are different, rotation is impossible.
        // This also handles the case where one is empty and the other is not.
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Edge Case: If both strings are empty, they are considered rotations of each other.
        if (s.empty()) {
            return true;
        }

        // Step 2: Concatenate s with itself.
        // Any possible rotation of s must exist as a contiguous substring within s + s.
        // Example: s = "abcde", s + s = "abcdeabcde"
        // Rotations: "bcdea" (starts at index 1), "cdeab" (starts at index 2), etc.
        string concatenated = s + s;
        
        // Step 3: Check if goal exists as a substring in the concatenated string.
        // The find() method returns string::npos if the substring is not found.
        if (concatenated.find(goal) != string::npos) {
            return true;
        }
        
        // If the goal string is not found, s cannot be rotated to match goal.
        return false;
    }
};

int main() {
    Solution sol;

    // Example 1: Input: s = "abcde", goal = "cdeab" -> true
    string s1 = "abcde";
    string goal1 = "cdeab";
    cout << "s = \"" << s1 << "\", goal = \"" << goal1 << "\", Output: " 
         << (sol.rotateString(s1, goal1) ? "true" : "false") << endl; 

    // Example 2: Input: s = "abcde", goal = "abced" -> false
    string s2 = "abcde";
    string goal2 = "abced";
    cout << "s = \"" << s2 << "\", goal = \"" << goal2 << "\", Output: " 
         << (sol.rotateString(s2, goal2) ? "true" : "false") << endl; 

    // Example 3: s = "a", goal = "a" -> true
    string s3 = "a";
    string goal3 = "a";
    cout << "s = \"" << s3 << "\", goal = \"" << goal3 << "\", Output: " 
         << (sol.rotateString(s3, goal3) ? "true" : "false") << endl; 

    return 0;
}
