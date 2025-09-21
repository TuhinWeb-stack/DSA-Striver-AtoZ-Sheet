#include <iostream>
#include <stdexcept>

using namespace std;

const int MAX_SIZE = 100;

class ArrayQueue {
private:
    int arr[MAX_SIZE];
    int front; // Pointer to the front of the queue
    int rear;  // Pointer to the rear of the queue

public:
    // Constructor initializes an empty queue
    ArrayQueue() {
        front = -1;
        rear = -1;
    }

    // Adds an element to the end of the queue
    void push(int x) {
        if (rear >= MAX_SIZE - 1) {
            cout << "Error: Queue Overflow!" << endl;
            return;
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = x;
    }

    // Removes and returns the front element of the queue
    int pop() {
        if (isEmpty()) {
            throw out_of_range("Error: Queue Underflow!");
        }
        int data = arr[front];
        if (front == rear) { // The last element is being removed
            front = -1;
            rear = -1;
        } else {
            front++;
        }
        return data;
    }

    // Returns the front element without removing it
    int peek() {
        if (isEmpty()) {
            throw out_of_range("Error: Queue is empty!");
        }
        return arr[front];
    }

    // Returns true if the queue is empty, false otherwise
    bool isEmpty() {
        return front == -1;
    }
};

int main() {
    ArrayQueue queue;
    cout << boolalpha;

    cout << "Pushing 5..." << endl;
    queue.push(5);

    cout << "Pushing 10..." << endl;
    queue.push(10);

    cout << "Peeking at the front element: " << queue.peek() << endl;

    cout << "Popping element: " << queue.pop() << endl;

    cout << "Is the queue empty? " << queue.isEmpty() << endl;

    return 0;
}
