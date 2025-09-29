#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    /**
     * Sorts a string in decreasing order based on the frequency of its characters.
     * Uses a combination of an unordered_map for counting and a bucket array for sorting.
     * * Time Complexity: O(N), where N is the length of the string.
     * Space Complexity: O(N) due to the bucket array.
     */
    string frequencySort(string s) {
        // Step 1: Count the frequency of each character.
        // Use unordered_map to handle all possible ASCII characters (uppercase, lowercase, digits).
        unordered_map<char, int> freq;
        for (char c : s) {
            freq[c]++;
        }

        // The maximum possible frequency is the length of the string.
        int max_freq = s.length();

        // Step 2: Create a bucket array based on frequency.
        // bucket[i] will store a string containing all characters that appeared 'i' times.
        // Size is max_freq + 1 to account for 0 to max_freq.
        vector<string> bucket(max_freq + 1);

        // Populate the buckets.
        for (auto const& [character, count] : freq) {
            // Create a string of length 'count' consisting only of 'character'
            // and append it to the corresponding frequency bucket.
            bucket[count] += string(count, character);
        }

        // Step 3: Build the result string by iterating the buckets in decreasing order.
        string result = "";
        
        // Iterate from the highest possible frequency (max_freq) down to 1.
        for (int i = max_freq; i >= 1; --i) {
            if (!bucket[i].empty()) {
                // Append the entire string from the current bucket.
                // Since all characters in bucket[i] have the same frequency, their relative 
                // order doesn't matter (e.g., "cccaaa" or "aaaccc" are both valid).
                result += bucket[i];
            }
        }

        return result;
    }
};

int main() {
    Solution sol;

    // Example 1: "tree" -> "eert" (e:2, r:1, t:1)
    string s1 = "tree";
    cout << "Input: \"" << s1 << "\", Output: \"" << sol.frequencySort(s1) << "\"" << endl; 

    // Example 2: "cccaaa" -> "aaaccc" (c:3, a:3)
    string s2 = "cccaaa";
    cout << "Input: \"" << s2 << "\", Output: \"" << sol.frequencySort(s2) << "\"" << endl; 

    // Example 3: "Aabb" -> "bbAa" (b:2, A:1, a:1)
    string s3 = "Aabb";
    cout << "Input: \"" << s3 << "\", Output: \"" << sol.frequencySort(s3) << "\"" << endl; 
    
    return 0;
}
