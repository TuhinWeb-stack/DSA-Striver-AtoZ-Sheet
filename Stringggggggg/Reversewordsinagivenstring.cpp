#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>

using namespace std;

class Solution {
public:
    string reverseWords(string s) {
        stringstream ss(s);
        string word;
        vector<string> words;
        while (ss >> word) {
            words.push_back(word);
        }

        if (words.empty()) {
            return "";
        }

        string result = "";
        for (int i = words.size() - 1; i >= 0; --i) {
            result += words[i];
            if (i > 0) {
                result += " ";
            }
        }
        return result;
    }
};

int main() {
    // Example 1
    Solution sol1;
    string s1 = "the sky is blue";
    cout << "Input: \"" << s1 << "\"" << endl;
    cout << "Output: \"" << sol1.reverseWords(s1) << "\"" << endl;

    // Example 2
    Solution sol2;
    string s2 = "  hello world  ";
    cout << "Input: \"" << s2 << "\"" << endl;
    cout << "Output: \"" << sol2.reverseWords(s2) << "\"" << endl;

    // Example 3
    Solution sol3;
    string s3 = "a good   example";
    cout << "Input: \"" << s3 << "\"" << endl;
    cout << "Output: \"" << sol3.reverseWords(s3) << "\"" << endl;

    // Edge case: string with only spaces
    Solution sol4;
    string s4 = "   ";
    cout << "Input: \"" << s4 << "\"" << endl;
    cout << "Output: \"" << sol4.reverseWords(s4) << "\"" << endl;

    // Edge case: string with single word
    Solution sol5;
    string s5 = "word";
    cout << "Input: \"" << s5 << "\"" << endl;
    cout << "Output: \"" << sol5.reverseWords(s5) << "\"" << endl;

    return 0;
}