#include <iostream>
#include <string>
#include <vector>
#include <algorithm> // Not strictly needed for the optimal approach, but useful for comparison

using namespace std;

class Solution {
public:
    /**
     * Determines if string t is an anagram of string s using a frequency array.
     * Time Complexity: O(N), where N is the length of the strings.
     * Space Complexity: O(1), as the size of the array is fixed at 26.
     */
    bool isAnagram(string s, string t) {
        // 1. Initial Check: If lengths are different, t cannot be an anagram of s.
        if (s.length() != t.length()) {
            return false;
        }

        // 2. Create a frequency map for the 26 lowercase English letters ('a' through 'z').
        int char_counts[26] = {0};

        // 3. Iterate through both strings simultaneously.
        // Increment the count for characters in s, and decrement the count for characters in t.
        for (int i = 0; i < s.length(); ++i) {
            // s[i] - 'a' gives an index from 0 to 25.
            char_counts[s[i] - 'a']++;
            char_counts[t[i] - 'a']--;
        }

        // 4. Check the frequency map.
        // If s and t are anagrams, every count must be exactly zero.
        for (int count : char_counts) {
            if (count != 0) {
                // If any character count is non-zero, the strings are not anagrams.
                return false;
            }
        }

        // 5. If all counts are zero, they are anagrams.
        return true;
    }
};

int main() {
    Solution sol;

    // Example 1: s = "anagram", t = "nagaram" -> true
    string s1 = "anagram";
    string t1 = "nagaram";
    cout << "s = \"" << s1 << "\", t = \"" << t1 << "\", Output: " 
         << (sol.isAnagram(s1, t1) ? "true" : "false") << endl; 

    // Example 2: s = "rat", t = "car" -> false
    string s2 = "rat";
    string t2 = "car";
    cout << "s = \"" << s2 << "\", t = \"" << t2 << "\", Output: " 
         << (sol.isAnagram(s2, t2) ? "true" : "false") << endl; 

    // Example 3: Different lengths -> false
    string s3 = "a";
    string t3 = "ab";
    cout << "s = \"" << s3 << "\", t = \"" << t3 << "\", Output: " 
         << (sol.isAnagram(s3, t3) ? "true" : "false") << endl; 

    return 0;
}
