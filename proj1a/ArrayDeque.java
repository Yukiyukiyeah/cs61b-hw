/**
 * Created by YukiTang on $(DATE).
 */

public class ArrayDeque<T>{
    private T[] items;
    private int size;
    int nextFirst;
    int nextLast;

    public ArrayDeque(){
        items = (T[])new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public ArrayDeque(ArrayDeque other){
        items = (T[])new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;

        for(int i=0;i<other.size();i++){
            addLast((T) other.get(i));
        }

    }

    private int plus(int index){
        return (index+1) % items.length;
    }

    private int minus(int index){
        return (index - 1 + items.length) % items.length;
    }

    private void resize(int resize){
        T[] result = (T[])new Object[resize];
        int current = plus(nextLast);
        for(int i = 0; i<items.length;i++){
            result[i] = items[current];
            current = plus(current);
        }
        items = result;
        nextFirst = resize-1;
        nextLast = size;
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        nextFirst = minus(nextFirst);
    }

    public void addLast(T item){
        if(size == items.length){
            resize(size*2);
        }
        items[nextLast] = item;
        size += 1;
        nextLast = plus(nextLast);
    }

    public boolean isEmpty(){
        if (size==0){
            return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    public void printDeque(){
        int current = plus(nextFirst);
        while(current != nextLast){
            System.out.print(items[current] + " ");
            current = plus(current);
        }
        System.out.println("");
    }

    public T removeFirst(){
        if(size == 0){
            return null;
        }
        int first = plus(nextFirst);
        T result = items[first];
        items[first] = null;
        nextFirst = first;
        size -= 1;

        if(items.length >= 16 && size < 0.25 * items.length){
            resize(items.length/2);
        }
        return result;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        int last = minus(nextLast);
        T result = items[last];
        items[last] = null;
        nextFirst = last;
        size -= 1;

        if(items.length >= 16 && size < 0.25 * items.length){
            resize(items.length/2);
        }
        return result;
    }

    public T get(int index){
        if(index<0 || index > size){
            return null;
        }
        index = (plus(nextFirst) + index)%items.length;
        return items[index];
    }

}