package org.example.searchsuggestionservice.service.serviceImp;


import org.example.searchsuggestionservice.dto.SearchSuggestion;
import org.example.searchsuggestionservice.repository.SearchSuggestionRepository;
import org.example.searchsuggestionservice.service.SearchSuggestionService;
import org.example.searchsuggestionservice.type.DefaultSuggestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;

@Service
public class SearchSuggestionServiceImpl  implements SearchSuggestionService {
    @Autowired(required = false)
    private SearchSuggestionRepository searchSuggestionRepository;
    @Override
    public List<String> getSuggestions(String searchTerm) {
        List<SearchSuggestion> existingSuggestions = searchSuggestionRepository.findByTermStartsWith(searchTerm);
        List<String> suggestions = new ArrayList<>();
        for (SearchSuggestion suggestion : existingSuggestions) {
            suggestions.add(suggestion.getKeyword());
        }
        return suggestions;
    }

    @Override
    public List<String> getDefaultSuggestion() {
        List<SearchSuggestion> defaultSuggestions = searchSuggestionRepository.findDefaultSuggestions(DefaultSuggestionType.DEFAULT);
        List<String> suggestionList = new ArrayList<>();
        for (SearchSuggestion suggestion : defaultSuggestions) {
            suggestionList.add(String.valueOf(suggestion.getLink()));
        }
        return suggestionList;
    }



}
