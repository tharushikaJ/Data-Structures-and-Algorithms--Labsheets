import java.util.Scanner;

class StackArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor for stack
    public StackArray(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    // Push method
    public void push(int item) {
        if (!isFull()) {
            stackArray[++top] = item;
            System.out.println("Pushed: " + item);
        } else {
            System.out.println("Error: Stack is full! Cannot push" + item);
        }
    }

    // Pop method
    public int pop() {
        if (!isEmpty()) {
            int popped = stackArray[top--];
            System.out.println("Popped: " + popped);
            return popped;
        } else {
            System.out.println("Error: Stack is empty! Cannot pop.");
            return -1;
        }
    }

    // Peek method
    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Error: Stack is empty! No top element.");
            return -1;
        }
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Display stack elements
    public void display() {
        if (!isEmpty()) {
            System.out.print("stack elements (top to bottom): ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Stack is empty!");
        }
    }

    // Reverse string using stack
    public static String reverseString(String input) {
        StackArrayChar stack = new StackArrayChar(input.length());
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Testing Stack operations
        StackArray stack = new StackArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Is stack full? " + stack.isFull());
        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.pop();
        System.out.println("Top element: " + stack.peek());
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Test String Reversal
        System.out.println("\nEnter a string to reverse: ");
        String inputString = scanner.nextLine();
        System.out.println("Reversed String: " + reverseString(inputString));

        // Testing balanced parentheses
        System.out.println("\nEnter a string with parentheses: ");
        String parenthesesString = scanner.nextLine();
        System.out.println("Balanced: " + isBalanced(parenthesesString));

    }

    // Method to check balanced parentheses
    public static boolean isBalanced(String str) {
        StackArrayChar stack = new StackArrayChar(str.length());
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!matches(top, c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }
}

// Separate stack class for characters
class StackArrayChar {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackArrayChar(int size) {
        this.maxSize = size;
        this.stackArray = new char[maxSize];
        this.top = -1;
    }

    public void push(char item) {
        if (!isFull()) {
            stackArray[++top] = item;
        }
    }

    public char pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return '\0';
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}
