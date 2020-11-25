/**
 * Created by YukiTang on $(DATE).
 */

public class LinkedListDeque<T> implements Deque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;
        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        Node temp = sentinel.next;
        while (temp.next != sentinel.next) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            Node temp = sentinel.next;
            temp.next.prev = sentinel;
            temp.prev.next = temp.next;
            size -= 1;
            return temp.item;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            Node temp = sentinel.prev;
            temp.prev.next = sentinel;
            sentinel.prev = temp.prev;
            size -= 1;
            return temp.item;
        }
        return null;
    }

    @Override
    public T get(int index) {
        if (!isEmpty() && index >= 0 && index <= size) {
            Node temp = sentinel;
            while (index >= 0) {
                temp = temp.next;
                index -= 1;
            }
            return temp.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (getNode(index) != null) {
            return getNode(index).item;
        }
        return null;
    }
    private Node getNode(int index) {
        if (!isEmpty() && index >= 0 && index <= size) {
            if (index == 0) {
                return sentinel.next;
            }
            return getNode(index - 1).next;
        }
        return null;
    }
}
