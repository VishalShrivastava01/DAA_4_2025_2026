public class dll {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;

    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    void delete(int value) {
        if (head == null) return;

        if (head.data == value) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != value) {
            temp = temp.next;
        }

        if (temp != null) {
            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            }
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        dll list = new dll();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.delete(20);
        list.display();
    }
}
