#include <iostream>
#include <vector>
#include <algorithm> // For std::swap and std::reverse

// As requested, I am using the std namespace globally.
using namespace std;

/**
 * @brief Rotates an n x n 2D matrix 90 degrees clockwise in-place.
 *
 * The rotation is achieved in two steps:
 * 1. Transpose the matrix: Swap elements across the main diagonal (matrix[i][j] <=> matrix[j][i]).
 * 2. Reverse each row: Reverse the elements of each individual row.
 *
 * @param matrix The n x n matrix to be rotated.
 */
void rotate(vector<vector<int>>& matrix) {
    int n = matrix.size();
    if (n == 0) {
        return;
    }

    // Step 1: Transpose the matrix
    for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            swap(matrix[i][j], matrix[j][i]);
        }
    }

    // Step 2: Reverse each row
    for (int i = 0; i < n; ++i) {
        reverse(matrix[i].begin(), matrix[i].end());
    }
}

/**
 * @brief Helper function to print a 2D matrix to the console.
 * @param matrix The matrix to be printed.
 */
void printMatrix(const vector<vector<int>>& matrix) {
    for (const auto& row : matrix) {
        for (int val : row) {
            cout << val << "\t";
        }
        cout << endl;
    }
}

int main() {
    // Example 1
    vector<vector<int>> matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    cout << "Original Matrix 1:" << endl;
    printMatrix(matrix1);

    rotate(matrix1);

    cout << "\nRotated Matrix 1:" << endl;
    printMatrix(matrix1);

    cout << "\n----------------------------------\n" << endl;

    // Example 2
    vector<vector<int>> matrix2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    cout << "Original Matrix 2:" << endl;
    printMatrix(matrix2);

    rotate(matrix2);

    cout << "\nRotated Matrix 2:" << endl;
    printMatrix(matrix2);

    return 0;
}