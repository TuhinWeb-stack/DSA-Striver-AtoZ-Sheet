#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
    string largestOddNumber(string num) {
        for (int i = num.length() - 1; i >= 0; --i) {
            int digit = num[i] - '0';
            if (digit % 2 != 0) {
                return num.substr(0, i + 1);
            }
        }
        return "";
    }
};

int main() {
    // Example 1
    Solution sol1;
    string num1 = "52";
    cout << "Input: " << num1 << endl;
    cout << "Output: " << sol1.largestOddNumber(num1) << endl;
    cout << endl;

    // Example 2
    Solution sol2;
    string num2 = "4206";
    cout << "Input: " << num2 << endl;
    cout << "Output: " << sol2.largestOddNumber(num2) << endl;
    cout << endl;

    // Example 3
    Solution sol3;
    string num3 = "35427";
    cout << "Input: " << num3 << endl;
    cout << "Output: " << sol3.largestOddNumber(num3) << endl;
    cout << endl;

    return 0;
}