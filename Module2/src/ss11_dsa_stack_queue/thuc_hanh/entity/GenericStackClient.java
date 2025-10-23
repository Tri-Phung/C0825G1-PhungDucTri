package ss11_dsa_stack_queue.thuc_hanh.entity;

public class GenericStackClient {
    private static void stackOfIStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 Size of stack after push operation: " + stack.size());
        System.out.println("1.2. Pop element from stack: ");
        stack.pop();
        System.out.print(stack);
        System.out.println("\n1.3. Size of stack after pop operation: " + stack.size());
    }
    public static void StackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        MyGenericStack<String> stack2 = new MyGenericStack<>();
        stack2.push("Five");
        stack2.push("Four");
        stack2.push("Three");
        stack2.push("Two");
        stack2.push("One");
        System.out.println(stack2);
        System.out.println("2.1 Size of stack after push operation: " + stack.size());
        System.out.println("2.2. Pop element from stack: ");
        stack.pop();
        System.out.print(stack);
        System.out.println("\n2.3. Size of stack after pop operation: " + stack.size());
    }

    static void main(String[] args) {
        System.out.println("Stack of integers: ");
        StackOfIntegers();
        System.out.println("Stack of strings: ");
        stackOfIStrings();
    }
}
