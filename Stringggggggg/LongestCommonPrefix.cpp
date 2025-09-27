#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
 * Finds the longest common prefix using the Vertical Scanning approach.
 */
class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        // 1. Handle the edge case of an empty input list.
        if (strs.empty()) {
            return "";
        }

        // 2. Initialize the prefix with the first string.
        string prefix = strs[0]; // Initial prefix: "flower"

        // 3. Iterate through the rest of the strings (starting from index 1).
        for (size_t i = 1; i < strs.size(); ++i) {
            
            // 4. Inner loop: Keep checking and shortening the prefix 
            //    until it is found at the start (index 0) of strs[i].
            while (strs[i].find(prefix) != 0) {
                
                // 5. Shorten the prefix by removing the last character.
                prefix = prefix.substr(0, prefix.length() - 1);
                
                // 6. If the prefix becomes empty, stop and return "".
                if (prefix.empty()) {
                    return "";
                }
            }
        }

        // 7. After checking all strings, the result is the final prefix.
        return prefix;
    }
};

int main() {
    Solution sol;
    
    // Example used for the trace:
    vector<string> strs1 = {"flower", "flow", "flight"};
    string result1 = sol.longestCommonPrefix(strs1);
    cout << "Input: {\"flower\", \"flow\", \"flight\"}" << endl;
    cout << "Output: \"" << result1 << "\"" << endl;

    return 0;
}
