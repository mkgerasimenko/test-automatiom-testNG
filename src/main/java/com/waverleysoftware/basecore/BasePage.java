package com.waverleysoftware.basecore;

import com.waverleysoftware.wait.WaitCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

import static com.waverleysoftware.basecore.BaseConfig.BASE_CONFIG;
import static com.waverleysoftware.listemers.TestListener.getWebDriver;
import static com.waverleysoftware.utils.ElementTypeUtils.*;
import static com.waverleysoftware.wait.WaitCondition.*;
import static java.util.Optional.ofNullable;

/**
 * A simple base class for processing common methods for all children classes.
 */
public abstract class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = getWebDriver();
        this.wait = new WebDriverWait(driver, BASE_CONFIG.waitTimeout());
    }

    protected void click(final By locator) {
        click(locator, enabled);
    }

    protected void click(final By locator, final WaitCondition condition) {
        elementOf(waitFor(locator, condition, "", "")).click();
    }

    protected void click(final By locator, final WaitCondition condition, final String value) {
        if (booleanOf(waitFor(locator, condition, value, ""))) {
            click(locator);
        }
    }

    protected void type(final By locator, final CharSequence text) {
        elementOf(waitFor(locator, present, "", "")).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text, final WaitCondition condition) {
        elementOf(waitFor(locator, condition, "", "")).sendKeys(text);
    }

    protected void type(final By locator, final CharSequence text, final boolean shouldClear) {

        if (shouldClear) {
            clearInputField(locator);
        }
        type(locator, text);
    }

    protected void type(final By locator,
                        final CharSequence text,
                        final WaitCondition condition,
                        final String verifiedValue) {
        elementOf(waitFor(locator, condition, verifiedValue, "")).sendKeys(text);
    }

    protected void clearInputField(final By locator) {
        click(locator, present);

        ofNullable(elementOf(waitFor(locator, present, "", "")))
                .filter(element -> !element.getAttribute("value").isEmpty())
                .ifPresent(WebElement::clear);
    }

    protected String getText(final By locator) {
        return elementOf(waitFor(locator, visible, "", "")).getText();
    }

    protected String getText(final By locator, final WaitCondition condition) {
        return elementOf(waitFor(locator, condition, "", "")).getText();
    }

    protected List<String> getTextNodes(final By locator, final WaitCondition condition) {
        return streamOf(waitFor(locator, condition, "", ""))
                .map(WebElement::getText)
                .toList();
    }

    protected String getTextWithAttr(final By locator, final String attr, final WaitCondition condition) {
        return elementOf(waitFor(locator, condition, "", "")).getAttribute(attr);
    }

    protected String getTextByAttr(final By locator, final String attr, final String value) {

        return booleanOf(waitFor(locator, attributeToBe, attr, value))
                ? value
                : "";
    }

    public Page navigateTo() {
        driver.get(url());
        return this;
    }

    @SuppressWarnings("unchecked")
    private <T, V, E, R> R waitFor(final T arg1, final WaitCondition condition, final V arg2, final E arg3) {
        return (R) wait.until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2, arg3));
    }
}
