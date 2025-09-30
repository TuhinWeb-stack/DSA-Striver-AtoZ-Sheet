#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
private:
    void expandAroundCenter(const string& s, int left, int right, int& start, int& maxLength) {
        while (left >= 0 && right < s.length() && s[left] == s[right]) {
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                maxLength = currentLength;
                start = left;
            }
            left--;
            right++;
        }
    }

public:
    string longestPalindrome(string s) {
        if (s.length() < 2) {
            return s;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < s.length(); ++i) {
            // Odd length palindromes (e.g., "aba")
            expandAroundCenter(s, i, i, start, maxLength);

            // Even length palindromes (e.g., "abba")
            expandAroundCenter(s, i, i + 1, start, maxLength);
        }

        return s.substr(start, maxLength);
    }
};

int main() {
    Solution sol;
    string s1 = "babad";
    cout << "Input: " << s1 << ", Output: " << sol.longestPalindrome(s1) << endl;

    string s2 = "cbbd";
    cout << "Input: " << s2 << ", Output: " << sol.longestPalindrome(s2) << endl;

    return 0;
}