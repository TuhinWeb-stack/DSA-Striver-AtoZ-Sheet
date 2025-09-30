#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

class Solution {
public:
    int beautySum(string s) {
        int total_beauty = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            vector<int> freq(26, 0);
            for (int j = i; j < n; ++j) {
                // Add the character to the current substring's frequency map
                freq[s[j] - 'a']++;

                // Find max and min frequencies for the current substring
                int max_freq = 0;
                int min_freq = INT_MAX;

                for (int k = 0; k < 26; ++k) {
                    if (freq[k] > 0) {
                        max_freq = max(max_freq, freq[k]);
                        min_freq = min(min_freq, freq[k]);
                    }
                }
                
                // Add the beauty to the total sum
                total_beauty += (max_freq - min_freq);
            }
        }
        return total_beauty;
    }
};

int main() {
    Solution sol;
    string s1 = "aabcb";
    cout << "Input: " << s1 << ", Output: " << sol.beautySum(s1) << endl;
    
    string s2 = "aabcbaa";
    cout << "Input: " << s2 << ", Output: " << sol.beautySum(s2) << endl;

    return 0;
}