#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

void bubbleSort(vector<int>& arr) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        bool swapped = false;
        // The inner loop boundary is n - 1 - i to prevent out-of-bounds access
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                swap(arr[j], arr[j + 1]);
                swapped = true; // Correctly update the flag
            }
        }
        // If no swaps were made in this pass, the array is sorted
        if (swapped==false) {
            break;
        }
    }
}

int main() {
    // Correctly initialize a std::vector from your array
    vector<int> arr = {2, 4, 1, 3};
    
    // You don't need to pass the size; the vector knows its own size
    bubbleSort(arr);
    
    // Loop through the vector and print its elements
    for (int x : arr) {
        cout << x << endl;
    }

    return 0;
}