#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

// Use the standard namespace
using namespace std;

class Solution {
public:
    vector<int> findDivisors(int n) {
        vector<int> divisors;
        if (n <= 0) {
            return divisors;
        }

        for (int i = 1; i * i <= n; ++i) { // Optimized loop condition
            if (n % i == 0) {
                divisors.push_back(i);
                if (i != n / i) {
                    divisors.push_back(n / i);
                }
            }
        }
        
        sort(divisors.begin(), divisors.end());
        
        return divisors;
    }
};

int main() {
    Solution sol;
    int n;
    cout << "Enter an integer: ";
    cin >> n;

    vector<int> result = sol.findDivisors(n);

    cout << "The divisors of " << n << " are: ";
    for (int divisor : result) {
        cout << divisor << " ";
    }
    cout << endl;

    return 0;
}