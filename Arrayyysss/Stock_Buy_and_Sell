#include <iostream>
#include <vector>
#include <algorithm> // Required for std::min and std::max

using namespace std; // Per user request

/**
 * @brief Finds the maximum profit from a single buy and sell transaction.
 * * Uses a single-pass greedy approach to track the minimum buying price.
 * @param prices The array of stock prices.
 * @return int The maximum profit achievable, or 0 if no profit is possible.
 */
int maxProfit(const vector<int>& prices) {
    // Constraint check ensures prices is not empty, but good practice to handle.
    if (prices.empty()) {
        return 0;
    }

    // Initialize minimum_price to the first day's price. 
    // This tracks the minimum price encountered so far (our best buying day).
    int minimum_price = prices[0];
    
    // Initialize max_profit to 0, as we must return 0 if no profit can be achieved.
    int max_profit = 0;
    
    // We iterate from the second day (index 1) to use the first day as the initial minimum.
    // We use 'start' as the loop index per your custom instruction.
    for (int start = 1; start < prices.size(); ++start) {
        // 1. Calculate the potential profit if we sell today (at prices[start])
        //    using the best (minimum) buying price found up to the previous day.
        int current_profit = prices[start] - minimum_price;
        
        // 2. Update the overall maximum profit found so far.
        //    We only update max_profit if the current_profit is higher.
        max_profit = max(max_profit, current_profit);
        
        // 3. Update the minimum price seen so far.
        //    This sets up the best possible buying price for future selling days (start + 1, ...).
        minimum_price = min(minimum_price, prices[start]);
    }
    
    return max_profit;
}

// Helper function for example execution
void printResult(const vector<int>& prices) {
    int result = maxProfit(prices);
    
    cout << "Input: [";
    for (size_t i = 0; i < prices.size(); ++i) {
        cout << prices[i] << (i < prices.size() - 1 ? ", " : "");
    }
    cout << "]\tOutput: " << result << endl;
}

int main() {
    // Example 1
    vector<int> prices1 = {7, 1, 5, 3, 6, 4};
    printResult(prices1); // Expected Output: 5

    // Example 2
    vector<int> prices2 = {7, 6, 4, 3, 1};
    printResult(prices2); // Expected Output: 0

    // Additional Test Case
    vector<int> prices3 = {2, 4, 1};
    printResult(prices3); // Expected Output: 2 (Buy at 2, Sell at 4)

    return 0;
}