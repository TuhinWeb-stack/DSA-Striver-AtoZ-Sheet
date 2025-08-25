#include <iostream>
#include <string>

using namespace std;

// Recursive helper function to check for a palindrome
bool isPalindromeRecursive(const string& s, int left, int right) {
    // Base case 1: If the pointers have met or crossed, the string is a palindrome.
    // This handles strings of odd or even length.
    if (left >= right) {
        return true;
    }

    // Base case 2: If the characters at the current positions don't match,
    // it's not a palindrome.
    if (s[left] != s[right]) {
        return false;
    }

    // Recursive step: If the characters match, check the inner substring.
    return isPalindromeRecursive(s, left + 1, right - 1);
}

// Public function to start the palindrome check
bool isPalindrome(const string& s) {
    // Handle edge cases for empty or single-character strings
    if (s.empty()) {
        return true;
    }
    
    return isPalindromeRecursive(s, 0, s.length() - 1);
}

int main() {
    string str;

    cout << "Enter a string: ";
    cin >> str; // Note: cin stops at the first whitespace

    if (isPalindrome(str)) {
        cout << "The string \"" << str << "\" is a palindrome." << endl;
    } else {
        cout << "The string \"" << str << "\" is not a palindrome." << endl;
    }

    return 0;
}