#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

class Queue {
private:
    Node* front;
    Node* rear;

public:
    Queue() {
        front = rear = NULL;
    }

    bool isEmpty() {
        return front == NULL;
    }

    void enqueue(int value) {
        Node* newNode = new Node();
        newNode->data = value;
        newNode->next = NULL;

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear->next = newNode;
            rear = newNode;
        }

        cout << value << " inserted into queue" << endl;
    }

    void dequeue() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
            return;
        }

        Node* temp = front;
        cout << front->data << " removed from queue" << endl;

        front = front->next;

        if (front == NULL) {
            rear = NULL;
        }

        delete temp;
    }

    void peek() {
        if (isEmpty()) {
            cout << "Queue is empty" << endl;
        } else {
            cout << "Front element: " << front->data << endl;
        }
    }
};

int main() {
    Queue q;

    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    q.peek();

    q.dequeue();
    q.peek();

    return 0;
}
