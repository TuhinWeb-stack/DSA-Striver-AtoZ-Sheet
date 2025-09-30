#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int maxDepth(string s) {
    int current_depth = 0;
    int max_depth = 0;

    for (char c : s) {
        if (c == '(') {
            current_depth++;
            max_depth = max(max_depth, current_depth);
        } else if (c == ')') {
            current_depth--;
        }
    }
    return max_depth;
}

int main() {
    string s1 = "(1+(2*3)+((8)/4))+1";
    cout << "Input: " << s1 << endl;
    cout << "Output: " << maxDepth(s1) << endl;

    string s2 = "(1)+((2))+(((3)))";
    cout << "Input: " << s2 << endl;
    cout << "Output: " << maxDepth(s2) << endl;

    string s3 = "()(())((()()))";
    cout << "Input: " << s3 << endl;
    cout << "Output: " << maxDepth(s3) << endl;

    return 0;
}