public class Experiment4 {

    static final int MAX = 100;
    int heapSize = 0;
    int[] heap = new int[MAX];

    void heapifyUp(int i) {
        while (i > 0 && heap[(i - 1) / 2] > heap[i]) {
            int temp = heap[i];
            heap[i] = heap[(i - 1) / 2];
            heap[(i - 1) / 2] = temp;

            i = (i - 1) / 2; 
        }
    }

    void insert(int val) {
        if (heapSize == MAX) {
            System.out.println("Heap full");
            return;
        }
        heap[heapSize] = val;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    void heapifyDown(int i) {

    int smallest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < heapSize && heap[left] < heap[smallest]) {
        smallest = left;
    }

    if (right < heapSize && heap[right] < heap[smallest]) {
        smallest = right;
    }

    if (smallest != i) {
        int temp = heap[i];
        heap[i] = heap[smallest];
        heap[smallest] = temp;

        heapifyDown(smallest);
    }
}

    void deleteMin() {

    if (heapSize == 0) {
        System.out.println("Heap empty");
        return;
    }

    heap[0] = heap[heapSize - 1];
    heapSize--;
    heapifyDown(0);
}

void deleteValue(int val) {
    int index = -1;

    for (int i = 0; i < heapSize; i++) {
        if (heap[i] == val) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("Value not found");
        return;
    }

    heap[index] = heap[heapSize - 1];
    heapSize--;

    if (index > 0 && heap[index] < heap[(index - 1) / 2]) {
        heapifyUp(index);
    } else {
        heapifyDown(index);
    }
}

    void display() {
        for (int i = 0; i < heapSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Experiment4 h = new Experiment4();

        h.insert(10);
        h.insert(20);
        h.insert(1);
        h.insert(0);
        h.insert(30);

        h.display();
        h.deleteMin();
        h.display();
        h.deleteValue(30);
        h.display();
    }
}
