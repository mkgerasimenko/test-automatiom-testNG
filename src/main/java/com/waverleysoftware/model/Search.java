package com.waverleysoftware.model;

import lombok.Data;

/**
 * A simple model class for search object.
 */
@Data
public class Search {

    private final String searchValue;
    private final String wikiLinkValue;
    private final String searchButton;
    private final String luckyButton;
    private final String currentCountry;
    private final int linksAmount;
}
