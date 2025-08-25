#include <iostream>

using namespace std;

// Recursive function to calculate the n-th Fibonacci number.
// Using 'long long' to handle larger numbers.
long long fib(int n) {
    // Base cases: F(0) = 0 and F(1) = 1.
    if (n <= 1) {
        return n;
    }

    // Recursive step: F(n) = F(n-1) + F(n-2)
    return fib(n - 1) + fib(n - 2);
}

int main() {
    int n;

    cout << "Enter a non-negative integer (n): ";
    cin >> n;

    // Input validation
    if (n < 0) {
        cout << "Fibonacci numbers are defined for non-negative integers." << endl;
    } else {
        long long result = fib(n);
        cout << "F(" << n << ") = " << result << endl;
    }

    return 0;
}