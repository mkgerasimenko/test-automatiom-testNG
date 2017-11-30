package com.waverleysoftware.pages;

import com.waverleysoftware.basecore.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.waverleysoftware.basecore.BaseConfig.BASE_CONFIG;
import static com.waverleysoftware.wait.WaitCondition.*;

/**
 * A simple model class which describes the behavior for Search page.
 */
public class SearchPage extends BasePage {

    private final By inputSearch = By.cssSelector("#lst-ib");
    private final By linkSearchResults = By.cssSelector("#rso h3 > a");
    private final By currentCountry = By.cssSelector("._Cbu");
    private final By searchButton = By.name("btnK");
    private final By luckyButton = By.name("btnI");

    public SearchPage searchFor(final String text) {
        type(inputSearch, text + Keys.ENTER, true);
        return this;
    }

    public void selectLink(final String value) {
        click(linkSearchResults, valueToBe, value);
    }

    public String getCountry() {
        return getText(currentCountry);
    }

    public String getNameForSearchBtn(final String attrValue) {
        return getTextWithAttr(searchButton, attrValue, visible);
    }

    public String getNameForLuckyBtn(final String attrValue) {
        return getTextWithAttr(luckyButton, attrValue, visible);
    }

    public int getLinksAmount() {
        return getTextNodes(linkSearchResults, allPresent).size();
    }

    public String getLinkTextFor(final int numberOfLink) {
        return getTextNodes(linkSearchResults, allPresent).get(numberOfLink - 1);
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
