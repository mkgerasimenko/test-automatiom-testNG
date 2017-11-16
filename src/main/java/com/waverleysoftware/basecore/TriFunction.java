package com.waverleysoftware.basecore;

/**
 * Represents a custom function that accepts three arguments and produces a result.
 *
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <E> the type of the third argument to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface TriFunction<T, U, E, R> {

    R apply(T t, U u, E e);
}
