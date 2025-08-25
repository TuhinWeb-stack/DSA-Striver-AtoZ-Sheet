#include <iostream>
#include <cmath>

// Use the standard namespace
using namespace std;

class Solution {
public:
    bool isPrime(int n) {
        // Prime numbers are defined for integers greater than 1.
        if (n <= 1) {
            return false;
        }

        // 2 is the only even prime number.
        if (n == 2) {
            return true;
        }

        // All other even numbers are not prime.
        if (n % 2 == 0) {
            return false;
        }

        // Check for odd divisors from 3 up to the square root of n.
        // We use i*i <= n to avoid floating-point issues and improve performance.
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        // If no divisors are found, the number is prime.
        return true;
    }
};

int main() {
    Solution sol;
    int n;
    cout << "Enter an integer: ";
    cin >> n;

    if (sol.isPrime(n)) {
        cout << n << " is a prime number." << endl;
    } else {
        cout << n << " is not a prime number." << endl;
    }

    return 0;
}