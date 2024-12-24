package YSixthPack;

public class Stack<WEIN> {
    private WEIN[] data;
    private int size;

    public Stack(int capacity){
    data = (WEIN[]) new Object[capacity];
    size = 0;
    }   
    public void push(WEIN element){
        if (size == data.length) {
            throw new StackOverflowError("Переполнение стека");
        }
        data[size] = element;
        size++;
    }
    public WEIN pop(){
        if (size == 0) {
            throw new IllegalStateException("Пустой стек");
        }
        WEIN element = data[size - 1];
        data[size-1]=null;
        size--;
        return element;
    }
    public WEIN peek(){
        if (size == 0) {
            throw new IllegalStateException("Пустой стек");
        }
        return data[size-1];
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(666);
        stack.push(12451515);
        stack.push(999999);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Peek: " + stack.peek());
    }
}