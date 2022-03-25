package CustomStack;

import java.util.function.Consumer;

public class Stack {
    private static class Node {

        private final int value;
        private Node prev;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node curr;
    private int size;

    public void push(int element) {
        Node node = new Node(element);
        if(curr == null) curr = node;
        else {
            node.prev = curr;
            curr = node;
        }
        size++;
    }
    public int pop(){
        if (curr == null) throw new NullPointerException();
        int temp = curr.value;
        curr = curr.prev;
        size--;
        return temp;
    }
    public int peek(){
        return curr.value;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void forEach(Consumer<Integer> consumer){
        Node temp = curr;
        while (temp != null){
            consumer.accept(temp.value);
            temp = temp.prev;
        }
    }
}
