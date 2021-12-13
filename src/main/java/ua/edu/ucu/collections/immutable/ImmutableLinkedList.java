package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private final Node tail;

//    Done
    public ImmutableLinkedList(Object[] elements) {
        Node previous = null;
        for (Object element : elements) {
            Node current = new Node(element);
            current.setPrevious(previous);

            if (previous == null) {
                this.head = current;
            } else {
                previous.setNext(current);
            }
            previous = current;
        }
        this.tail = previous;
    }

//    Done
    public ImmutableLinkedList() {
        this.head = null;
        this.tail = null;
    }

//    Done
    @Override
    public ImmutableList add(Object e) {
        return addAll(size(), new Object[]{e});
    }

//    Done
    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

//    Done
    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

//    Done
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Object[] output = new Object[size() + c.length];
        Object[] elements = toArray();

        for (int i = 0; i < index; i++) {
            output[i] = elements[i];
        }
        for (int i = index; i < index + c.length; i++) {
            output[i] = c[i - index];
        }
        for (int i = index + c.length; i < size() + c.length; i++) {
            output[i] = elements[i - c.length];
        }

        return new ImmutableLinkedList(output);
    }

//    Done
    @Override
    public Object get(int index) {
        Object output = this.head.getValue();
        Node node = this.head;
        int i = 0;
        while (node != null) {
            if (i == index) {
                output = node.getValue();
            }
            node = node.getNext();
            i++;
        }

        return output;
    }

//    Done
    @Override
    public ImmutableList remove(int index) {
        int length = size()-1;
        Object[] output = new Object[length];

        Node node = this.head;

        int i = 0;
        while (i < length) {
            if (i == index) {
                node = node.getNext();
            }
            output[i] = node.getValue();
            node = node.getNext();
            i++;
        }
        return new ImmutableLinkedList(output);
    }

//    Done
    @Override
    public ImmutableList set(int index, Object e) {
        Object[] output = toArray();
        output[index] = e;
        return new ImmutableLinkedList(output);
    }

//    Done
    @Override
    public int indexOf(Object e) {
        int index = 0;

        Node node = this.head;

        while (node != null) {
            if (node.getValue() != e) {
                return index;
            }
            node = node.getNext();
            index++;
        }

        return -1;
    }

//    Done
    @Override
    public int size() {
        int size = 0;

        Node node = this.head;

        while (node != null) {
            node = node.getNext();
            size++;
        }

        return size;
    }

//    Done
    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

//    Done
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

//    Done
    @Override
    public Object[] toArray() {
        Object[] output = new Object[size()];

        Node node = this.head;

        int i = 0;
        while (node != null) {
            output[i] = node.getValue();
            node = node.getNext();
            i++;
        }

        return output;
    }

//    Done
    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) addAll(0, new Object[]{e});
    }

//    Done
    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

//    Done
    public Node getHead() {
        return this.head;
    }

//    Done
    public Node getTail() {
        return tail;
    }

//    Done
    public Object getFirst() {
        return this.head.getValue();
    }

//    Done
    public Object getLast() {
        return this.tail.getValue();
    }

//    Done
    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

//    Done
    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size()-1);
    }
}
