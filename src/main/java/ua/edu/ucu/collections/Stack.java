package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedList = new ImmutableLinkedList();

    public void push(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }

    public Object pop() {
        Object deleted = this.linkedList.getLast();
        this.linkedList = this.linkedList.removeLast();
        return deleted;
    }

    public Object peek() {
        return this.linkedList.getLast();
    }
}
