package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (fillCount == this.capacity) {
            throw new RuntimeException("Ring Buffer Overflow");
        }
        rb[last] = x;
        fillCount += 1;
        last = (last + 1) % this.capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        T item = rb[first];
        rb[first] = null;
        fillCount -= 1;
        first = (first + 1) % this.capacity;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }
        return rb[first];
    }


    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator<T> implements Iterator<T> {
        private int ptr;

        public BufferIterator() {
            ptr = 0;
        }

        @Override
        public boolean hasNext() {
            return ptr != last;
        }

        @Override
        public T next() {
            T returnItem = (T) rb[ptr];
            ptr =  (ptr + 1) % capacity;
            return returnItem;
        }
    }
}
