import java.util.Scanner;

class QueueArray {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int count; // Track number of elements

    // Constructor
    public QueueArray(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Insert item at the rear (Circular behavior)
    public void insert(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % maxSize;  // Circular move
        queueArray[rear] = item;
        count++;
    }

    // Remove and return the front item (Circular behavior)
    public int remove() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = queueArray[front];
        front = (front + 1) % maxSize;  // Circular move
        count--;
        return item;
    }

    // Return the front item without removing it
    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queueArray[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return count == maxSize;
    }

    // Get the number of elements in the queue
    public int getCount() {
        return count;
    }

    // Main method to test the queue
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the circular queue: ");
        int size = scanner.nextInt();

        QueueArray queue = new QueueArray(size);

        System.out.println("Inserting elements into the queue...");
        for (int i = 1; i <= size; i++) {
            System.out.print("Enter element " + i + ": ");
            int value = scanner.nextInt();
            queue.insert(value);
        }

        System.out.println("Queue is full? " + queue.isFull());
        System.out.println("Front item: " + queue.peekFront());

        System.out.println("Removing two elements...");
        System.out.println("Removed: " + queue.remove());
        System.out.println("Removed: " + queue.remove());

        System.out.println("Inserting new elements to test circular behavior...");
        queue.insert(99);
        queue.insert(100);

        System.out.println("Current front: " + queue.peekFront());
        System.out.println("Current count: " + queue.getCount());

        System.out.println("Final queue state:");
        while (!queue.isEmpty()) {
            System.out.println("Removed: " + queue.remove());
        }

        System.out.println("Queue is empty? " + queue.isEmpty());
        scanner.close();
    }
}
