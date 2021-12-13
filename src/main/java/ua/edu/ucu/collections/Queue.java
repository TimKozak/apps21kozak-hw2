package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedList = new ImmutableLinkedList();
    public Object peek() {
        return this.linkedList.getFirst();
    }

    public Object dequeue() {
        Object deleted = this.linkedList.getFirst();
        this.linkedList = this.linkedList.removeFirst();
        return deleted;
    }

    public void enqueue(Object e) {
        this.linkedList = this.linkedList.addLast(e);
    }
}
