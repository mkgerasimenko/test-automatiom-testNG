package com.waverleysoftware.wait;

import com.waverleysoftware.basecore.TriFunction;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * An enum for processing of waiting conditions.
 */
@Getter
@RequiredArgsConstructor
public enum WaitCondition {
    visible(ExpectedConditions::visibilityOfElementLocated),
    enabled((Function<By, ExpectedCondition<?>>) ExpectedConditions::elementToBeClickable),
    present(ExpectedConditions::presenceOfElementLocated),
    allVisible(ExpectedConditions::visibilityOfAllElementsLocatedBy),
    allPresent(ExpectedConditions::presenceOfAllElementsLocatedBy),
    titleIs(ExpectedConditions::titleIs),
    valueToBe(ExpectedConditions::textToBe),
    textPresentInValue((BiFunction<By, String, ExpectedCondition<?>>)
            ExpectedConditions::textToBePresentInElementValue),
    attributeToBe((TriFunction<By, String, String, ExpectedCondition<?>>)
            ExpectedConditions::attributeToBe);
    private final TriFunction<?, ?, ?, ExpectedCondition<?>> type;

    <T, V> WaitCondition(final Function<T, ExpectedCondition<?>> condition) {
        this((T arg1, V arg2) -> condition.apply(arg1));
    }

    <T, V, E> WaitCondition(final BiFunction<T, V, ExpectedCondition<?>> condition) {
        this((T arg1, V arg2, E arg3) -> condition.apply(arg1, arg2));
    }

    @SuppressWarnings("unchecked")
    public <T, V, E, R> TriFunction<T, V, E, R> getType() {
        return (TriFunction<T, V, E, R>) type;
    }
}
