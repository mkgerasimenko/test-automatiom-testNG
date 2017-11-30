package com.waverleysoftware.testcases;

import com.waverleysoftware.basecore.BaseTest;
import com.waverleysoftware.data.Data;
import com.waverleysoftware.data.DataSuppliers;
import com.waverleysoftware.model.Client;
import com.waverleysoftware.model.Search;
import com.waverleysoftware.pages.SearchPage;
import org.testng.annotations.Test;

import static com.waverleysoftware.assertions.CustomAssertions.assertThatE;
import static com.waverleysoftware.basecore.PageFactory.at;
import static com.waverleysoftware.basecore.PageFactory.open;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * A simple class for Google page testing.
 */
@SuppressWarnings("MultipleStringLiterals")
public class GoogleTests extends BaseTest {

    @Data(source = "data-for-search-test.json", entity = Search.class)
    @Data(source = "client.csv", entity = Client.class)
    @Test(dataProvider = "getDataCollection", dataProviderClass = DataSuppliers.class)
    public void shouldSearchForKeyword(final Search search, final Client client) {
        open(SearchPage.class)
                .searchFor(client.getFirstName() + " " + client.getLastName() + " " + search.getCurrentCountry());

        assertThatE(search).hasNumberOfLinks(at(SearchPage.class).getLinksAmount());
    }

    @Data(source = "data-for-search-test.json", entity = Search.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void searchedValueShouldBeDisplayed(final Search search) {
        open(SearchPage.class)
                .searchFor(search.getSearchValue());

        assertThat(at(SearchPage.class).getLinkTextFor(1))
                .isEqualTo(search.getWikiLinkValue());
    }

    @Data(source = "data-for-search-test.json", entity = Search.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void valuesShouldBeCorrect(final Search search) {
        open(SearchPage.class);

        assertThatE(search)
                .hasSearchBtnName(at(SearchPage.class).getNameForSearchBtn("value"));

        assertThatE(search)
                .hasLuckyBtnName(at(SearchPage.class).getNameForLuckyBtn("value"));

        assertThatE(search)
                .hasCountry(at(SearchPage.class).getCountry());
    }
}
