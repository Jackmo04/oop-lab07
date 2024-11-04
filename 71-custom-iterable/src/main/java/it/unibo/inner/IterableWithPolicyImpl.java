package it.unibo.inner;

import java.util.Arrays;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

/**
 * Takes an array to be iterated. 
 * A <i>filter</i> (implemented with {@link Predicate}) can be used to specify which element to be shown.
 */
public class IterableWithPolicyImpl<T> implements IterableWithPolicy<T> {

    private T array[];
    private Predicate<T> filter;

    /**
     * If no {@link Predicate} is specified, no filter will be applied
     * @param array The array to be iterated
     */
    public IterableWithPolicyImpl(final T[] array) {
        this(array, new Predicate<T>() {
            @Override
            public boolean test(T elem) {
                return true;
            }
        });
    }

    /**
     * Array to iterate with a filter specified by a {@link Predicate}
     * @param array The array to be iterated
     * @param filter The filter to apply
     */
    public IterableWithPolicyImpl(final T[] array, final Predicate<T> filter) {
        this.array = Arrays.copyOf(array, array.length); // Defensive copy
        this.filter = filter;
    }


    @Override
    public Iterator<T> iterator() {
        return new IterableWithPolicyImplIterator();
    }

    @Override
    public void setIterationPolicy(final Predicate<T> filter) {
        this.filter = filter;
    }

    private class IterableWithPolicyImplIterator implements Iterator<T>{

        private int index;

        @Override
        public boolean hasNext() {
            while (index < array.length && !filter.test(array[index])) {
                index++;
            }
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
