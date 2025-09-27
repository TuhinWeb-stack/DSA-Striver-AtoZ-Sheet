#include <iostream>
#include <string>
#include <vector>

using namespace std;

/**
 * Determines if two strings s and t are isomorphic.
 * This requires a perfect one-to-one (bijective) character mapping.
 */
class Solution {
public:
    bool isIsomorphic(string s, string t) {
        // Since the constraints guarantee equal length, this check is mostly defensive.
        if (s.length() != t.length()) {
            return false;
        }

        // We use two arrays of size 256 (for the full ASCII range) to act as hash maps.
        // They are initialized to 0, indicating 'no mapping established yet'.
        
        // s_to_t: Maps a character from s to the corresponding character in t.
        int s_to_t[256] = {0};
        
        // t_to_s: Maps a character from t to the corresponding character in s.
        // This is crucial to prevent multiple characters from s mapping to the same 
        // character in t (e.g., preventing 'o' and 'f' from both mapping to 'a').
        int t_to_s[256] = {0};

        for (int i = 0; i < s.length(); ++i) {
            char char_s = s[i];
            char char_t = t[i];

            // --- Check 1: Has char_s been mapped before? ---
            if (s_to_t[char_s] != 0) {
                // Yes, it has. Check if the existing mapping is consistent.
                if (s_to_t[char_s] != char_t) {
                    // Inconsistency found (e.g., 'f' -> 'b', then later 'f' -> 'a').
                    return false; 
                }
            }
            // --- Check 2: char_s is new. Establish a new map, but check the reverse. ---
            else {
                // Before mapping s->t, check if the target char_t is already 
                // mapped by another character from s.
                if (t_to_s[char_t] != 0) {
                    // Violation of one-to-one rule (e.g., "foo" -> "bar"). 
                    // 'f' mapped to 'b', now 'o' tries to map to 'a', 
                    // but if another char from s had already claimed 'a', it fails.
                    return false; 
                }

                // If both checks pass, establish the new, bidirectional mapping.
                s_to_t[char_s] = char_t;
                t_to_s[char_t] = char_s;
            }
        }

        // If the entire loop completes without returning false, the strings are isomorphic.
        return true;
    }
};

int main() {
    Solution sol;

    // Example 1: "egg", "add" -> true
    string s1 = "egg";
    string t1 = "add";
    cout << "Input: s = \"" << s1 << "\", t = \"" << t1 << "\", Output: " << (sol.isIsomorphic(s1, t1) ? "true" : "false") << endl; 

    // Example 2: "foo", "bar" -> false (Crucial test for bijection)
    string s2 = "foo";
    string t2 = "bar";
    cout << "Input: s = \"" << s2 << "\", t = \"" << t2 << "\", Output: " << (sol.isIsomorphic(s2, t2) ? "true" : "false") << endl; 

    // Example 3: "paper", "title" -> true
    string s3 = "paper";
    string t3 = "title";
    cout << "Input: s = \"" << s3 << "\", t = \"" << t3 << "\", Output: " << (sol.isIsomorphic(s3, t3) ? "true" : "false") << endl; 
    
    // Example 4: "ab", "aa" -> false (Violates bijection: 'a' -> 'a', then 'b' tries to map to 'a' again)
    string s4 = "ab";
    string t4 = "aa";
    cout << "Input: s = \"" << s4 << "\", t = \"" << t4 << "\", Output: " << (sol.isIsomorphic(s4, t4) ? "true" : "false") << endl; 

    return 0;
}
