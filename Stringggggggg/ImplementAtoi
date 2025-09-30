#include <iostream>
#include <string>
#include <climits>

using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        long long result = 0;
        int i = 0;
        int sign = 1;

        // 1. Skip leading whitespace
        while (i < s.length() && s[i] == ' ') {
            i++;
        }

        // 2. Determine sign
        if (i < s.length() && (s[i] == '-' || s[i] == '+')) {
            sign = (s[i] == '-') ? -1 : 1;
            i++;
        }

        // 3. Convert digits and handle overflow
        while (i < s.length() && isdigit(s[i])) {
            int digit = s[i] - '0';

            // Check for positive overflow
            if (sign == 1 && (result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > 7))) {
                return INT_MAX;
            }
            // Check for negative overflow
            if (sign == -1 && (result > INT_MAX / 10 || (result == INT_MAX / 10 && digit > 8))) {
                return INT_MIN;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
};

int main() {
    Solution sol;
    cout << "Input: \"42\", Output: " << sol.myAtoi("42") << endl;
    cout << "Input: \" -042\", Output: " << sol.myAtoi(" -042") << endl;
    cout << "Input: \"1337c0d3\", Output: " << sol.myAtoi("1337c0d3") << endl;
    cout << "Input: \"0-1\", Output: " << sol.myAtoi("0-1") << endl;
    cout << "Input: \"words and 987\", Output: " << sol.myAtoi("words and 987") << endl;
    cout << "Input: \"-91283472332\", Output: " << sol.myAtoi("-91283472332") << endl;
    cout << "Input: \"2147483648\", Output: " << sol.myAtoi("2147483648") << endl;
    cout << "Input: \"-2147483648\", Output: " << sol.myAtoi("-2147483648") << endl;
    return 0;
}