#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

int romanToInt(string s) {
    unordered_map<char, int> roman_map = {
        {'I', 1},
        {'V', 5},
        {'X', 10},
        {'L', 50},
        {'C', 100},
        {'D', 500},
        {'M', 1000}
    };

    int result = 0;
    for (int i = 0; i < s.length(); ++i) {
        if (i + 1 < s.length() && roman_map[s[i]] < roman_map[s[i+1]]) {
            result -= roman_map[s[i]];
        } else {
            result += roman_map[s[i]];
        }
    }
    return result;
}

int main() {
    string s1 = "III";
    cout << "Input: " << s1 << ", Output: " << romanToInt(s1) << endl;
    
    string s2 = "LVIII";
    cout << "Input: " << s2 << ", Output: " << romanToInt(s2) << endl;

    string s3 = "MCMXCIV";
    cout << "Input: " << s3 << ", Output: " << romanToInt(s3) << endl;

    return 0;
}