#include<iostream>
using namespace std;

class Node{
    public:
    int data;
    Node*next;

    Node(int data){
        this->data=data;
        this->next=NULL;
    }
};

void insertAtHead(Node* &head, int d){
    Node*temp = new Node(d);
    temp->next= head;
    head=temp;
}

void insertAtTail(Node*&tail, int d){
    Node*temp=new Node(d);
    tail->next=temp;
    tail=temp;
}

void insertAtPosition(Node*&tail, Node*&head, int position , int d){
    if(position == 1){
        insertAtHead(head,d);
        return;
    }
    Node*temp= head;
    int cnt =1;
    while(cnt<position-1){
        temp=temp->next;
        cnt++;
    }
    if(temp->next==NULL){
        insertAtTail(tail,d);
        return;
    }
    Node*inserNewNode= new Node(d);
    inserNewNode->next =temp->next;
    temp->next=inserNewNode;
}

void print(Node*&head){
    Node*temp=head;
    while (temp!=NULL)
    {
        cout<<temp->data<<"  ";
        temp=temp->next;
    }
}


int main(){
    Node* node1= new Node(10);
    //cout<<node1-> data<<endl;
    //cout<<node1-> next<<endl;
    Node*head=node1;
    Node*tail=node1;
    insertAtHead(head,12);
    insertAtTail(tail,15);
    insertAtPosition(tail,head,2,11);
    print(head);
    cout<<endl;
    cout<<"Head:  "<<head->data<<endl;
    cout<<"Tail:  "<<tail->data<<endl;


    return 0;
}