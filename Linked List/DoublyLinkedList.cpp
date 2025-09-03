#include<iostream>
using namespace std;

class Node{
public:
    int data;
    Node* prev;
    Node* next;

    Node(int d){
        this->data = d;
        this->prev = NULL;
        this->next = NULL;
    }
    // Destructor to free memory
    ~Node(){
        int value = this->data;
        if(this->next != NULL){
            delete next;
            this->next = NULL;
        }
        cout << "The memory is free for node with data: " << value << endl;
    }
};

void insertAtHead(Node*& head ,Node*& tail, int d){
    Node* temp = new Node(d);
    if(head == NULL){
        head = temp;
        tail = temp;
    }
    else{
        temp->next = head;
        head->prev = temp;
        head = temp;
    }
}

void insertAtTail(Node*& head, Node*& tail, int d){
    Node* temp = new Node(d);
    if(tail == NULL){
        head = temp;
        tail = temp;
    }
    else{
        tail->next = temp;
        temp->prev = tail;
        tail = temp;
    }
}

void insertAtAnyPosition(Node*& head, Node*& tail , int position, int d){
    if(position == 1){
        insertAtHead(head, tail, d);
        return;
    }
    
    Node* temp = head;
    int cnt = 1;
    while(cnt < position - 1 && temp != NULL){
        temp = temp->next;
        cnt++;
    }

    if(temp == NULL || temp->next == NULL){
        insertAtTail(head, tail, d);
        return;
    }

    Node* nodeToInsert = new Node(d);
    nodeToInsert->next = temp->next;
    temp->next->prev = nodeToInsert;
    temp->next = nodeToInsert;
    nodeToInsert->prev = temp;
}

void deleteNode(int position, Node*& head, Node*& tail) {
    // Deleting the head node (position 1)
    if (position == 1) {
        Node* temp = head;
        head = temp->next;
        if (head != NULL) {
            head->prev = NULL;
        }
        temp->next = NULL;
        delete temp;
        // If the list becomes empty after deletion
        if (head == NULL) {
            tail = NULL;
        }
    }
    // Deleting a middle or tail node
    else {
        Node* current = head;
        int cnt = 1;

        while (cnt < position) {
            current = current->next;
            cnt++;
        }

        // Deleting the tail node
        if (current->next == NULL) {
            tail = current->prev;
            tail->next = NULL;
            current->prev = NULL;
        } 
        // Deleting a middle node
        else {
            current->prev->next = current->next;
            current->next->prev = current->prev;
        }

        current->next = NULL;
        current->prev = NULL;
        delete current;
    }
}

void print(Node* head){
    Node* temp = head;
    int length = 0;
    while (temp != NULL){
        cout << temp->data << " ";
        temp = temp->next;
        length++;
    }
    cout << endl;
    cout << "Length of linked list is: " << length << endl;
}

int main(){
    Node* head = NULL;
    Node* tail = NULL;

    cout << "--- Building the list ---" << endl;
    insertAtHead(head, tail, 10);
    insertAtHead(head, tail, 12);
    insertAtHead(head, tail, 14);
    insertAtHead(head, tail, 16);
    insertAtTail(head, tail, 18);
    insertAtAnyPosition(head, tail, 4, 15);
    insertAtAnyPosition(head, tail, 7, 20);

    cout << "\n--- Initial List ---" << endl;
    print(head);
    cout << "Head: " << head->data << endl;
    cout << "Tail: " << tail->data << endl;

    cout << "\n--- Deleting a single element at position 4 ---" << endl;
    deleteNode(4, head, tail);
    
    cout << "\n--- List after deletion ---" << endl;
    print(head);
    cout << "Head: " << head->data << endl;
    cout << "Tail: " << tail->data << endl;
    
    return 0;
}