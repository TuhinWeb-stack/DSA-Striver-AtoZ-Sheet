#include <iostream>
#include <vector>

// Per your preference, I'm using the std namespace.
using namespace std;

/**
 * @brief Returns all elements of a matrix in spiral order.
 *
 * This function uses four pointers (top, bottom, left, right) to define the
 * boundaries of the current layer of the matrix. It iterates layer by layer,
 * moving inwards, and adds elements to the result vector.
 *
 * @param matrix The m x n input matrix.
 * @return A vector<int> containing elements in spiral order.
 */
vector<int> spiralOrder(vector<vector<int>>& matrix) {
    vector<int> result;
    if (matrix.empty() || matrix[0].empty()) {
        return result;
    }

    int m = matrix.size();
    int n = matrix[0].size();
    int top = 0, bottom = m - 1;
    int left = 0, right = n - 1;

    while (top <= bottom && left <= right) {
        // 1. Traverse Right (across the top row)
        for (int j = left; j <= right; ++j) {
            result.push_back(matrix[top][j]);
        }
        top++;

        // 2. Traverse Down (along the right column)
        for (int i = top; i <= bottom; ++i) {
            result.push_back(matrix[i][right]);
        }
        right--;

        // Check if there's still a valid row to traverse
        if (top <= bottom) {
            // 3. Traverse Left (across the bottom row)
            for (int j = right; j >= left; --j) {
                result.push_back(matrix[bottom][j]);
            }
            bottom--;
        }

        // Check if there's still a valid column to traverse
        if (left <= right) {
            // 4. Traverse Up (along the left column)
            for (int i = bottom; i >= top; --i) {
                result.push_back(matrix[i][left]);
            }
            left++;
        }
    }

    return result;
}

/**
 * @brief Helper function to print a vector.
 * @param vec The vector to print.
 * @param name A descriptive name for the output.
 */
void printVector(const vector<int>& vec, const string& name) {
    cout << name << ": [";
    for (size_t i = 0; i < vec.size(); ++i) {
        cout << vec[i] << (i == vec.size() - 1 ? "" : ",");
    }
    cout << "]" << endl;
}

int main() {
    // Example 1
    vector<vector<int>> matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    vector<int> result1 = spiralOrder(matrix1);
    printVector(result1, "Output for Example 1");

    cout << "\n--------------------------\n" << endl;

    // Example 2
    vector<vector<int>> matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    vector<int> result2 = spiralOrder(matrix2);
    printVector(result2, "Output for Example 2");

    return 0;
}