#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string removeOuterParentheses(string s) {
        string result = "";
        int balance = 0;
        for (char c : s) {
            if (c == '(') {
                if (balance > 0) {
                    result += c;
                }
                balance++;
            } else { // c == ')'
                balance--;
                if (balance > 0) {
                    result += c;
                }
            }
        }
        return result;
    }
};

int main() {
    // Example 1
    Solution sol1;
    string s1 = "(()())(())";
    cout << "Input: " << s1 << endl;
    cout << "Output: " << sol1.removeOuterParentheses(s1) << endl;
    cout << endl;

    // Example 2
    Solution sol2;
    string s2 = "(()())(())(()(()))";
    cout << "Input: " << s2 << endl;
    cout << "Output: " << sol2.removeOuterParentheses(s2) << endl;
    cout << endl;

    // Example 3
    Solution sol3;
    string s3 = "()()";
    cout << "Input: " << s3 << endl;
    cout << "Output: " << sol3.removeOuterParentheses(s3) << endl;
    cout << endl;

    return 0;
}