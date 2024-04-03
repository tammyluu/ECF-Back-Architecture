package org.example.searchsuggestionservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchSuggestion {
    String keyword;
    StringBuilder link;
    Integer rank;

    public SearchSuggestion(String keyword, StringBuilder link, Integer rank) {
        this.keyword = keyword;
        this.link = new StringBuilder(link);
        this.rank = rank;
    }


}
