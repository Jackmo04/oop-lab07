package it.unibo.inner;

import java.util.Arrays;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private T array[];

    public IterableWithPolicyImpl(T[] array) {
        // Defensive copy
        this.array = Arrays.copyOf(array, array.length);
    }

    @Override
    public Iterator<T> iterator() {
        return new IterableWithPolicyImplIterator();
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIterationPolicy'");
    }

    private class IterableWithPolicyImplIterator implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            T elem = array[index];
            index++;
            return elem;
        }
        
    }

}
