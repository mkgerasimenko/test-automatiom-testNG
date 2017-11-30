package com.waverleysoftware.assertions;

import com.waverleysoftware.model.Search;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Search Page assert processing.
 */
public class SearchPageAssert extends AbstractAssert<SearchPageAssert, Search> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public SearchPageAssert(final Search search) {
        super(search, SearchPageAssert.class);
    }

    public SearchPageAssert hasSearchedName(final String searchedName) {
        isNotNull();

        final String nameOfSearch = actual.getSearchValue();

        if (!Objects.areEqual(nameOfSearch, searchedName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Search name", actual, searchedName, nameOfSearch);
        }
        return this;
    }

    public SearchPageAssert hasCountry(final String currentCountry) {
        isNotNull();

        final String country = actual.getCurrentCountry();

        if (!Objects.areEqual(country, currentCountry)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Country name", actual, currentCountry, country);
        }
        return this;
    }

    public SearchPageAssert hasLuckyBtnName(final String luckyBtnName) {
        isNotNull();

        final String luckyButton = actual.getLuckyButton();

        if (!Objects.areEqual(luckyButton, luckyBtnName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Lucky button name", actual, luckyBtnName, luckyButton);
        }
        return this;
    }

    public SearchPageAssert hasSearchBtnName(final String searchBtnName) {
        isNotNull();

        final String searchButton = actual.getSearchButton();

        if (!Objects.areEqual(searchButton, searchBtnName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Search button name", actual, searchBtnName, searchButton);
        }
        return this;
    }

    public SearchPageAssert hasNumberOfLinks(final int amountOfLinks) {
        isNotNull();

        final int linksAmount = actual.getLinksAmount();

        if (linksAmount != amountOfLinks) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Amount of links", actual, amountOfLinks, linksAmount);
        }
        return this;
    }
}
