package StackIterator;

import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node top;

    private class Node {
        private T value;
        private Node prev;

        public Node(T element) {
            this.value = element;
        }

        public void setNextNode(Node top) {
            this.prev = top;
        }
    }

    public void push(T element) {
        Node tempNode = new Node(element);
        tempNode.setNextNode(top);
        top = tempNode;
    }

    public void pop() {
        if (top != null) {
            Node temp = top;
            top = top.prev;
        } else System.out.println("No elements");
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node temp = top;
            @Override
            public boolean hasNext() {
                return temp != null;
            }

            @Override
            public T next() {
                T v = temp.value;
                temp = temp.prev;
                return v;
            }
        };
    }
}
