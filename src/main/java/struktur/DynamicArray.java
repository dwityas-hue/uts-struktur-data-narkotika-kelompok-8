package struktur;

public class DynamicArray<T> implements StrukturData<T> {
    private Object[] data;
    private int size;

    public DynamicArray() {
        this(10);
    }

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Kapasitas harus lebih dari 0");
        }
        data = new Object[capacity];
        size = 0;
    }

    private void resize() {
        Object[] baru = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            baru[i] = data[i];
        }
        data = baru;
    }

    @Override
    public void add(T value) {
        if (size == data.length) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public void insert(int position, T value) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(
                    "Posisi insert " + position + " di luar batas, ukuran = " + size);
        }
        if (size == data.length) {
            resize();
        }
        for (int i = size; i > position; i--) {
            data[i] = data[i - 1];
        }
        data[position] = value;
        size++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                    "Posisi " + position + " di luar batas, ukuran = " + size);
        }
        return (T) data[position];
    }

    @SuppressWarnings("unchecked")
    public T set(int position, T value) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                    "Posisi " + position + " di luar batas, ukuran = " + size);
        }
        T lama = (T) data[position];
        data[position] = value;
        return lama;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(
                    "Posisi " + position + " di luar batas, ukuran = " + size);
        }
        T dihapus = (T) data[position];
        for (int i = position; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return dihapus;
    }

    public int search(T value) {
        for (int i = 0; i < size; i++) {
            if (value == null) {
                if (data[i] == null) {
                    return i;
                }
            } else if (value.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    public void validateInvariant() {
        if (data == null) {
            throw new IllegalStateException("Invariant dilanggar: array internal null");
        }
        if (size < 0 || size > data.length) {
            throw new IllegalStateException("Invariant dilanggar: size di luar rentang kapasitas");
        }
        for (int i = size; i < data.length; i++) {
            if (data[i] != null) {
                throw new IllegalStateException("Invariant dilanggar: sisa slot tidak null pada indeks " + i);
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return search(value) != -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }
}