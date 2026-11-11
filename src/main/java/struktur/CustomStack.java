package struktur;

import java.util.EmptyStackException;

public class CustomStack<T> {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 100;

    public CustomStack() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Elemen yang dimasukkan tidak boleh null.");
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) elements[--size];
        elements[size] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean searchPreserve(T value) {
        if (value == null || isEmpty()) {
            return false;
        }

        CustomStack<T> tempStack = new CustomStack<>();
        boolean found = false;

        while (!this.isEmpty()) {
            T current = this.pop();
            if (current.equals(value)) {
                found = true;
            }
            tempStack.push(current);
        }

        restore(tempStack);
        return found;
    }

    public void restore(CustomStack<T> tempStack) {
        while (!tempStack.isEmpty()) {
            this.push(tempStack.pop());
        }
    }

    public boolean validateInvariant() {
        if (size < 0 || size > elements.length) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) {
                return false;
            }
        }
        return true;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }
}