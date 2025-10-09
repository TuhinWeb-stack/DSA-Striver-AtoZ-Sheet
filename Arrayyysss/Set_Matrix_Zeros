#include <iostream>
#include <vector>

// Always use namespace std as requested.
using namespace std;

void setZeroes(vector<vector<int>>& matrix) {
    int m = matrix.size();
    if (m == 0) return;
    int n = matrix[0].size();
    if (n == 0) return;

    bool is_first_col_zero = false;

    // Step 1: Use the first row and column as markers.
    // We use a separate flag for the first column because matrix[0][0]
    // is used to mark the first row.

    // Check if the first column needs to be zeroed out.
    for (int i = 0; i < m; ++i) {
        if (matrix[i][0] == 0) {
            is_first_col_zero = true;
            break;
        }
    }

    // Iterate through the rest of the matrix to mark the first row/col.
    for (int i = 0; i < m; ++i) {
        for (int j = 1; j < n; ++j) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0; // Mark the row
                matrix[0][j] = 0; // Mark the column
            }
        }
    }

    // Step 2: Zero out the inner matrix based on the markers.
    // We iterate from (1,1) to avoid clearing our markers yet.
    for (int i = 1; i < m; ++i) {
        for (int j = 1; j < n; ++j) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }

    // Step 3: Zero out the first row if needed.
    // matrix[0][0] acts as the marker for the first row.
    if (matrix[0][0] == 0) {
        for (int j = 0; j < n; ++j) {
            matrix[0][j] = 0;
        }
    }

    // Step 4: Zero out the first column if the flag was set.
    if (is_first_col_zero) {
        for (int i = 0; i < m; ++i) {
            matrix[i][0] = 0;
        }
    }
}

// Helper function to print the matrix
void printMatrix(const vector<vector<int>>& matrix) {
    for (const auto& row : matrix) {
        cout << "[";
        for (int i = 0; i < row.size(); ++i) {
            cout << row[i] << (i == row.size() - 1 ? "" : ",");
        }
        cout << "]" << endl;
    }
    cout << endl;
}

int main() {
    // Example 1
    vector<vector<int>> matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    cout << "Example 1 Input:" << endl;
    printMatrix(matrix1);
    setZeroes(matrix1);
    cout << "Example 1 Output:" << endl;
    printMatrix(matrix1);

    // Example 2
    vector<vector<int>> matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    cout << "Example 2 Input:" << endl;
    printMatrix(matrix2);
    setZeroes(matrix2);
    cout << "Example 2 Output:" << endl;
    printMatrix(matrix2);

    return 0;
}