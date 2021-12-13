package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {
    private int size;
    private Object[] elements;

//    Done
    public ImmutableArrayList(Object[] elements) {
        this.size = elements.length;
        this.elements = Arrays.copyOf(elements,
                elements.length);
    }

//    Done
    public ImmutableArrayList() {
        this.size = 0;
        this.elements = new Object[]{};
    }

//    Done
    @Override
    public ImmutableList add(Object e) {
        return add(this.size, e);
    }

//    Done
    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[] {e});
    }

//    Done
    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(this.size, c);
    }

//    Done
    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] output = new Object[this.size + c.length];

        System.arraycopy(elements, 0, output, 0, index);
        System.arraycopy(c, 0, output, index, c.length);

        for (int i = index + c.length; i < this.size + c.length; i++) {
            output[i] = elements[i - c.length];
        }

        return new ImmutableArrayList(output);
    }

//    Done
    @Override
    public Object get(int index) {
        return this.elements[index];
    }

//    Done
    @Override
    public ImmutableList remove(int index) {
        Object[] output = new Object[this.size];

        System.arraycopy(this.elements, 0, output, 0, index);
        System.arraycopy(this.elements, index + 1, output, index,
                this.size - (index + 1));

        this.size--;

        return new ImmutableArrayList(output);
    }

//    Done
    @Override
    public ImmutableList set(int index, Object e) {
        Object[] output = new Object[this.size];

        for (int i = 0; i < output.length; i++) {
            if (i == index) {
                output[i] = e;
            } else {
                output[i] = this.elements[i];
            }
        }

        return new ImmutableArrayList(output);
    }

//    Done
    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i] == e) {
                return i;
            }
        }
        return -1;
    }

//    Done
    @Override
    public int size() {
        return this.size;
    }

//    Done
    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

//    Done
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

//    Done
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.size);
    }
}
